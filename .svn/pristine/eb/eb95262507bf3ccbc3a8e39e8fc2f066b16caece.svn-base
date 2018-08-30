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
import org.szd.base.entity.BaseRoleUrlMap;
import org.szd.base.service.BaseRoleUrlMapService;
import org.work.platform.dao.BaseDao;
import org.work.platform.service.impl.BaseServiceImpl;
import org.work.platform.dao.support.Page;

@Service
public class BaseRoleUrlMapServiceImpl extends BaseServiceImpl<BaseRoleUrlMap> implements BaseRoleUrlMapService{
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "baseRoleUrlMapDao")  
   public void setDao(BaseDao<BaseRoleUrlMap> dao) {  
       super.setDao(dao);  
   } 
   
	@Override
	public Page findPage(BaseRoleUrlMap baseRoleUrlMap, int pageSize, int pageNo) {
		Map<String,Object> values=new HashMap<String,Object>();
		return getPagedNamedQuery("base::BaseRoleUrlMap::findPage", pageNo, pageSize, values);
	}
   
}
