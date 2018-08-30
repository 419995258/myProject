/*
 * wangzhen
 * date 2017
 */

package org.szd.base.service.impl;

import java.util.*;

/**
 * @author wangzhen
 * @version 1.0
 * @since 1.0
 */


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szd.base.entity.BasePropertiesGroup;
import org.szd.base.service.BasePropertiesGroupService;
import org.work.platform.dao.BaseDao;
import org.work.platform.service.impl.BaseServiceImpl;
import org.work.platform.dao.support.Page;

@Service
public class BasePropertiesGroupServiceImpl extends BaseServiceImpl<BasePropertiesGroup> implements BasePropertiesGroupService{
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "basePropertiesGroupDao")  
   public void setDao(BaseDao<BasePropertiesGroup> dao) {  
       super.setDao(dao);  
   } 
   
	@Override
	public Page findPage(BasePropertiesGroup basePropertiesGroup, int pageSize, int pageNo) {
		Map<String,Object> values=new HashMap<String,Object>();
		return getPagedNamedQuery("base::BasePropertiesGroup::findPage", pageNo, pageSize, values);
	}
   
}
