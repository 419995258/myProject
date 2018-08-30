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
import org.szd.base.entity.BaseUrl;
import org.szd.base.service.BaseUrlService;
import org.work.platform.dao.BaseDao;
import org.work.platform.service.impl.BaseServiceImpl;
import org.work.platform.dao.support.Page;

@Service
public class BaseUrlServiceImpl extends BaseServiceImpl<BaseUrl> implements BaseUrlService{
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "baseUrlDao")  
   public void setDao(BaseDao<BaseUrl> dao) {  
       super.setDao(dao);  
   } 
   
	@Override
	public Page findPage(BaseUrl baseUrl, int pageSize, int pageNo) {
		Map<String,Object> values=new HashMap<String,Object>();
		if(isNotEmpty(baseUrl.getModuleId())) {
			values.put("moduleId", baseUrl.getModuleId());
		}
		return getPagedNamedQuery("base::BaseUrl::findPage", pageNo, pageSize, values);
	}
   
}
