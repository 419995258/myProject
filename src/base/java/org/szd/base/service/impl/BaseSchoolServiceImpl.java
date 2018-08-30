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
import org.szd.base.entity.BaseSchool;
import org.szd.base.service.BaseSchoolService;
import org.work.platform.dao.BaseDao;
import org.work.platform.service.impl.BaseServiceImpl;
import org.work.platform.dao.support.Page;

@Service
public class BaseSchoolServiceImpl extends BaseServiceImpl<BaseSchool> implements BaseSchoolService{
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "baseSchoolDao")  
   public void setDao(BaseDao<BaseSchool> dao) {  
       super.setDao(dao);  
   } 
   
	@Override
	public Page findPage(BaseSchool baseSchool, int pageSize, int pageNo) {
		Map<String,Object> values=new HashMap<String,Object>();
		return getPagedNamedQuery("base::BaseSchool::findPage", pageNo, pageSize, values);
	}
   
}
