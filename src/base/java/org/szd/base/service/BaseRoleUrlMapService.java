/*
 * wangzhen
 * date 2017
 */

package org.szd.base.service;

import java.util.*;

/**
 * @author wangzhen
 * @version 1.0
 * @since 1.0
 */


import org.szd.base.entity.BaseRoleUrlMap;
import org.work.platform.dao.support.Page;
import org.work.platform.service.BaseService;

public interface BaseRoleUrlMapService extends BaseService<BaseRoleUrlMap>{

	/**
	 * 分页查询
	 * @param baseRoleUrlMap
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	Page findPage(BaseRoleUrlMap baseRoleUrlMap, int pageSize, int pageNo);
}
