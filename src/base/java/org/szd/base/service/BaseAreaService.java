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


import org.szd.base.entity.BaseArea;
import org.work.platform.dao.support.Page;
import org.work.platform.service.BaseService;

public interface BaseAreaService extends BaseService<BaseArea>{

	/**
	 * 分页查询
	 * @param baseArea
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	Page findPage(BaseArea baseArea, int pageSize, int pageNo);
}
