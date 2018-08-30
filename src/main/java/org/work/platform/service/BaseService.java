package org.work.platform.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.work.platform.dao.support.Page;

/**
 * 通用service 接口
 * @author wangzhen
 *
 * @param <T>
 */
public interface BaseService<T> {

	/**
	 * 保存
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * 保存或更新
	 * @param entity
	 */
	void saveOrUpdate(T entity);
	
	/**
	 * 更新
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * 删除
	 * @param id
	 */
	void delete(Serializable id);
	
	/**
	 * 删除
	 * @param entity
	 */
	void delete(T entity);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	T findById(Serializable id);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll(String orderBy,boolean isAsc);
	
	/**
	 * sqlName查询
	 * @param queryName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List getNamedQuery(String queryName);
	
	/**
	 * sqlName查询
	 * @param queryName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List getNamedQuery(String queryName, Map values);
	
	/**
	 * sqlName翻页查询
	 * @param queryName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Page getPagedNamedQuery(String queryName, int pageNo, int pageSize, Map values);
	
	/**
	 * 复杂sql翻页，需要两条语句，一条列表查询，一条count查询所有条数。
	 * @param queryName
	 * @param countQueryName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Page getPagedNamedQuery(String queryName,String countQueryName, int pageNo, int pageSize, Map values);
	
	/**
	 * 判断是否为空
	 * @param obj
	 * @return
	 */
	boolean isNotEmpty(Object obj);
	
	void onValid(T entity);
}
