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


import org.szd.base.entity.BaseSchool;
import org.work.platform.dao.support.Page;
import org.work.platform.service.BaseService;

public interface BaseSchoolService extends BaseService<BaseSchool>{

	/**
	 * 分页查询
	 * @param baseSchool
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	Page findPage(BaseSchool baseSchool, int pageSize, int pageNo);
}
