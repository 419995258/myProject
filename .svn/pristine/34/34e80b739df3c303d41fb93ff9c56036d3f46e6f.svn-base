package org.work.platform.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.work.platform.dao.BaseDao;
import org.work.platform.dao.support.Page;
import org.work.util.GenericsUtils;

import javacommon.xsqlbuilder.XsqlBuilder;
import javacommon.xsqlbuilder.XsqlBuilder.XsqlFilterResult;
import redis.RedisUtil;

/**
 * DAO 通用操作实现
 * @author wangzhen
 *
 * @param <T>
 */
public class BaseDaoImpl <T> implements BaseDao<T>{
	
	public static String preKey="base_BaseQuery_queryName_";
	
	private Class<T> clazz;  
	
	@Autowired
	public RedisUtil redisManager;
	
    /** 
    * 向DAO层注入SessionFactory 
    */  
	@Autowired 
   private SessionFactory sessionFactory;  
   
   /** 
    * 获取与当前线程绑定的session 
    * @return 
    */  
   private Session getSession(){  
       return sessionFactory.getCurrentSession();    
   }  
   
   /** 
    * 重新打开一个session 
    * @return 
    */  
   protected Session openSession(){  
   	return sessionFactory.openSession();
   }  
	
	@Override
	public void save(T entity) {
		this.getSession().save(entity);
	}
	
	@Override
	public void saveOrUpdate(T entity) {
		this.getSession().saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		this.getSession().update(entity); 
	}

	@Override
	public void delete(Serializable id) {
		this.getSession().delete(this.findById(id));
	}
	
	
	@Override
	public void delete(T entity) {
		this.getSession().delete(entity);
	}

	@Override
	public T findById(Serializable id) {
		return (T) this.getSession().get(this.clazz, id);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
	    Session session = getSession();  
        Criteria criteria = session.createCriteria(clazz);  
        return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(String orderBy,boolean isAsc) {
		Session session = getSession();  
		Criteria criteria = session.createCriteria(clazz);  
		if (isAsc)
			return (List<T>) criteria.addOrder(Order.asc(orderBy)).list();
		else
			return (List<T>) criteria.addOrder(Order.desc(orderBy)).list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getNamedQuery(String queryName) {
		Map<String,Object> define = getBaseQuery(queryName);
		List list = new ArrayList();
		if (define != null) {
			String queryString=define.get("queryString").toString();
			XsqlBuilder xsqlBuilder = new XsqlBuilder();
			XsqlFilterResult result = xsqlBuilder.generateHql(queryString,new HashMap<String,Object>());
			String queryType=define.get("queryType").toString();
			if (queryType.equals("hql")) {
				list = find(result.getXsql());
			}
			if (queryType.equals("sql")) {
				list = findSql(result.getXsql());
			}
		}
		
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getNamedQuery(String queryName, Map values) {
		Map<String,Object> define = getBaseQuery(queryName);
		
		List list = new ArrayList();
		if (define != null) {
			String queryString=define.get("queryString").toString();
			XsqlBuilder xsqlBuilder = new XsqlBuilder();
			XsqlFilterResult result = xsqlBuilder.generateHql(queryString, values);
			String queryType=define.get("queryType").toString();
			if (queryType.equals("hql")) {
				list = find(result.getXsql(), result.getAcceptedFilters());
			}
			
			if (queryType.equals("sql")) {
				list = findSql(result.getXsql(),result.getAcceptedFilters());
			}
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page getPagedNamedQuery(String queryName, int pageNo, int pageSize, Map values) {
		Map<String,Object> define = getBaseQuery(queryName);
		
		Page page = null;
		if(define!=null){
			String queryString=define.get("queryString").toString();
			XsqlBuilder xsqlBuilder = new XsqlBuilder();
			XsqlFilterResult result = xsqlBuilder.generateHql(queryString, values);
			String queryType=define.get("queryType").toString();
			if (queryType.equals("hql")) {
				page = pageQuery(result.getXsql(), pageNo, pageSize,result.getAcceptedFilters());
			}
			if (queryType.equals("sql")) {
				page = pageSQLQuery(result.getXsql(), pageNo, pageSize,result.getAcceptedFilters());
			}
		}
		
		return page;
	}
	
	/**
	 * 判断一个对象是否为空，为空返回false 不为空返回true
	 * @param obj
	 * @return
	 */
	public boolean isNotEmpty(Object obj){
		if(obj!=null&&!obj.equals("")&&!obj.equals("null")){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 获取查询对象
	 * @param queryName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String,Object> getBaseQuery(final String queryName) {
		Map<String,Object> define = null;
		String key=preKey+queryName;
		if (redisManager.hasKey(key)) {
			define = (Map<String,Object>) redisManager.getHash(key);
		}
		return define;
	}
	
	/**
	 * 执行原生sql查询
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findSql(String sql) {
		Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	/**
	 * 执行hql查询
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List find(String hql) {
		Session session = getSession();  
		Query query=session.createQuery(hql);
		return query.list();
	}
	
	
	@SuppressWarnings("rawtypes")
	public List find(String hql, Map values) {
		Query query = createQuery(hql,values);
		return query.list();
	}
	
	@SuppressWarnings("rawtypes")
	public List findSql(String sql, Map values) {
		Query query = createSQLQuery(sql,values).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	@SuppressWarnings("rawtypes")
	public Page pageQuery(String hql, int pageNo, int pageSize,Map values) {
		// Count查询
		Query query = createQuery(hql, values);
		long totalCount = Long.valueOf(query.list().size()) ;

		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		
		List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();

		return new Page(startIndex, totalCount, pageSize, list);
	}
	
	@SuppressWarnings("rawtypes")
	public Page pageQuery(String hql, int pageNo, int pageSize,Map values,Long totalCount) {
		// Count查询
		Query query = createQuery(hql, values);
		
		if (totalCount < 1)
			return new Page();
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		
		List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
		
		return new Page(startIndex, totalCount, pageSize, list);
	}
	
	@SuppressWarnings("rawtypes")
	public Query createQuery(String hql, Map values) {
		Query query = getSession().createQuery(hql);
		
		Set s=values.keySet();
		for (Iterator it = s.iterator(); it.hasNext();) {
            Object key = it.next();
            query.setParameter(key.toString(), values.get(key));
        }
		return query;
	}
	
	@SuppressWarnings("rawtypes")
	public Page pageSQLQuery(String sql, int pageNo, int pageSize, Map values) {

		Query query = createSQLQuery(sql, values).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		String count="COUNT(*)";
		String sqllow=sql.toLowerCase();
		String totalSql = sql.substring( sqllow.indexOf("from"), sql.length()); 
		if(sqllow.contains("union")||sqllow.contains("join")){
			totalSql = "SELECT "+count+" from("+sql+")";
		}else{
			if(sqllow.indexOf("distinct")!=-1){
				sqllow=sqllow.replace("select ", "");
				sqllow=sqllow.replace(sqllow.substring(sqllow.indexOf("from"), sqllow.length()), "");
				String[] sqls=sqllow.split(",");
				for(String s:sqls){
					if(s.indexOf("distinct")!=-1){
						count="COUNT("+s+")";
					}
				}
			}
			totalSql = "SELECT "+count+" "+totalSql;
		}
		
		Query queryCount = createSQLQuery(totalSql, values);
		
		int num=Integer.valueOf(((Map)queryCount.uniqueResult()).get("COUNT(*)").toString()); 
		
		long totalCount = Long.valueOf(num);

		if (totalCount < 1)
			return new Page();

		int startIndex = Page.getStartOfPage(pageNo, pageSize);

		List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();

		return new Page(startIndex, totalCount, pageSize, list);
	}
	
	@SuppressWarnings("rawtypes")
	public Page pageSQLQuery(String sql, int pageNo, int pageSize, Map values,Long totalCount) {
		
		Query query = createSQLQuery(sql, values).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		if (totalCount < 1)
			return new Page();
		
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		
		List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
		
		return new Page(startIndex, totalCount, pageSize, list);
	}
	
	@SuppressWarnings("rawtypes")
	public Query createSQLQuery(String sql, Map values) {
		Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		Set s = values.keySet();
		for (Iterator it = s.iterator(); it.hasNext();) {
			Object key = it.next();
			query.setParameter(key.toString(), values.get(key));
		}
		return query;
	}
	

	@SuppressWarnings("rawtypes")
	@Override
	public Page getPagedNamedQuery(String queryName, String countQueryName, int pageNo, int pageSize, Map values) {
		Map<String,Object> define = getBaseQuery(queryName);
		Map<String,Object> countDefine = getBaseQuery(countQueryName);
		
		Page page = null;
		Long count = 0l;
		if(define!=null&&countDefine!=null){
			String queryString=define.get("queryString").toString();
			String countQueryString=countDefine.get("queryString").toString();
			XsqlBuilder xsqlBuilder = new XsqlBuilder();
			XsqlFilterResult result = xsqlBuilder.generateHql(queryString, values);
			XsqlFilterResult countResult = xsqlBuilder.generateHql(countQueryString, values);
			String queryType=define.get("queryType").toString();
			String countQueryType=countDefine.get("queryType").toString();
			if (countQueryType.equals("hql")) {
				count = findCount(countResult.getXsql(),result.getAcceptedFilters());
			}
			if (countQueryType.equals("sql")) {
				count = findCountSql(countResult.getXsql(),result.getAcceptedFilters());
			}
			if (queryType.equals("hql")) {
				page = pageQuery(result.getXsql(), pageNo, pageSize,result.getAcceptedFilters(),count);
			}
			if (queryType.equals("sql")) {
				page = pageSQLQuery(result.getXsql(), pageNo, pageSize,result.getAcceptedFilters(),count);
			}
		}
		
		return page;
	}

	@SuppressWarnings("rawtypes")
	private Long findCountSql(String sql, Map values) {
		Query queryCount = createSQLQuery(sql, values);
		int num=Integer.valueOf(((Map)queryCount.uniqueResult()).get("COUNT(*)").toString()); 
		long totalCount = Long.valueOf(num);
		return totalCount;
	}

	@SuppressWarnings("rawtypes")
	private Long findCount(String hql, Map values) {
		Query query = createQuery(hql, values);
		long totalCount = Long.valueOf(query.list().get(0).toString()) ;
		return totalCount;
	}

	/**
	 * 在构造函数中将泛型T.class赋给entityClass.
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		clazz = GenericsUtils.getSuperClassGenricType(getClass());
	}

}
