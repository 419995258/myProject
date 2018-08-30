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


import org.szd.base.entity.BaseProperties;
import org.work.platform.dao.support.Page;
import org.work.platform.service.BaseService;

public interface BasePropertiesService extends BaseService<BaseProperties>{

	/**
	 * 分页查询
	 * @param baseProperties
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	Page findPage(BaseProperties baseProperties, int pageSize, int pageNo);
}
