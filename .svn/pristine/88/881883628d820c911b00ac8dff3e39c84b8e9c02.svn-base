package org.szd.base.service;

import org.szd.base.entity.BaseRole;
import org.work.platform.dao.support.Page;
import org.work.platform.service.BaseService;

public interface BaseRoleService extends BaseService<BaseRole>{
	
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
	Page findPage(BaseRole baseRole, int pageSize, int pageNo);
	
	/**
	 * 缓存单个对象
	 * @param baseQuery
	 */
	void cacheOne(BaseRole baseRole);
	
	void delCacheOne(String roleCode);
}
