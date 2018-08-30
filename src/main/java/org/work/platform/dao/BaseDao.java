package org.work.platform.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.work.platform.dao.support.Page;

/**
 * BaseDao 定义DAO通用操作
 * @author wangzhen
 *
 * @param <T>
 */
public interface BaseDao<T> {
	
	void save(T entity);
	
	void saveOrUpdate(T entity);
	
	void update(T entity);
	
	void delete(Serializable id);
	
	void delete(T entity);
	
	T findById(Serializable id);
	
	List<T> findAll();
	
	List<T> findAll(String orderBy,boolean isAsc);
	
	@SuppressWarnings("rawtypes")
	List getNamedQuery(String queryName);
	
	@SuppressWarnings("rawtypes")
	List getNamedQuery(String queryName, Map values);
	
	@SuppressWarnings("rawtypes")
	Page getPagedNamedQuery(String queryName, int pageNo, int pageSize, Map values);
	
	@SuppressWarnings("rawtypes")
	Page getPagedNamedQuery(String queryName,String countQueryName, int pageNo, int pageSize, Map values);
	
}
