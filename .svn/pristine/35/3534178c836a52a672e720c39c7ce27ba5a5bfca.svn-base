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
import org.szd.base.entity.BaseUser;
import org.szd.base.service.BaseUserService;
import org.work.platform.dao.BaseDao;
import org.work.platform.service.impl.BaseServiceImpl;
import org.work.platform.dao.support.Page;

@Service
public class BaseUserServiceImpl extends BaseServiceImpl<BaseUser> implements BaseUserService{
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "baseUserDao")  
   public void setDao(BaseDao<BaseUser> dao) {  
       super.setDao(dao);  
   } 
   
	@Override
	public Page findPage(BaseUser baseUser, int pageSize, int pageNo) {
		Map<String,Object> values=new HashMap<String,Object>();
		return getPagedNamedQuery("base::BaseUser::findPage", pageNo, pageSize, values);
	}
   
}
