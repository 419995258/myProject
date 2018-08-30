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
import org.szd.base.entity.BaseProperties;
import org.szd.base.service.BasePropertiesService;
import org.work.platform.dao.BaseDao;
import org.work.platform.service.impl.BaseServiceImpl;
import org.work.platform.dao.support.Page;

@Service
public class BasePropertiesServiceImpl extends BaseServiceImpl<BaseProperties> implements BasePropertiesService{
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "basePropertiesDao")  
   public void setDao(BaseDao<BaseProperties> dao) {  
       super.setDao(dao);  
   } 
   
	@Override
	public Page findPage(BaseProperties baseProperties, int pageSize, int pageNo) {
		Map<String,Object> values=new HashMap<String,Object>();
		return getPagedNamedQuery("base::BaseProperties::findPage", pageNo, pageSize, values);
	}
   
}
