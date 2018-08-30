package org.szd.base.service;

import org.szd.base.entity.BaseQuery;
import org.work.platform.dao.support.Page;
import org.work.platform.service.BaseService;

public interface BaseQueryService extends BaseService<BaseQuery>{
	
	/**
	 * 加载到缓存
	 */
	void initCache();

	/**
	 * 分页查询
	 * @param query
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	Page findPage(BaseQuery query, int pageSize, int pageNo);
	
	/**
	 * 缓存单个对象
	 * @param baseQuery
	 */
	void cacheOne(BaseQuery baseQuery);
	
	void delCacheOne(String queryName);
}
