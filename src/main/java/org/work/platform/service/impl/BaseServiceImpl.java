package org.work.platform.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.work.platform.dao.BaseDao;
import org.work.platform.dao.support.Page;
import org.work.platform.service.BaseService;

/**
 * 通用service接口实现
 * @author wangzhen
 *
 * @param <T>
 */
public class BaseServiceImpl<T> implements BaseService<T> {
	
    /** 
    * 注入BaseDao 
    */  
   private BaseDao<T> dao;  
   
   @Resource  
   public void setDao(BaseDao<T> dao) {  
       this.dao = dao;  
   }

	@Override
	public void save(T entity) {
		onValid((T) entity);
		dao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		onValid((T) entity);
		dao.saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		onValid((T) entity);
		dao.update(entity);
	}

	@Override
	public void delete(Serializable id) {
		dao.delete(id);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	public void onValid(T entity) {
	}
	
	@Override
	public T findById(Serializable id) {
		return dao.findById(id);
	}
	
	@Override
	public List<T> findAll() {
		return dao.findAll();
	}
	
	@Override
	public List<T> findAll(String orderBy,boolean isAsc) {
		return dao.findAll(orderBy,isAsc);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getNamedQuery(String queryName) {
		return dao.getNamedQuery(queryName);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getNamedQuery(String queryName, Map values) {
		return dao.getNamedQuery(queryName, values);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page getPagedNamedQuery(String queryName, int pageNo, int pageSize, Map values) {
		return dao.getPagedNamedQuery(queryName, pageNo, pageSize, values);
	}
	

	@Override
	public Page getPagedNamedQuery(String queryName, String countQueryName, int pageNo, int pageSize, Map values) {
		return dao.getPagedNamedQuery(queryName,countQueryName, pageNo, pageSize, values);
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

}
