/*
 * wangzhen
 * date 2017
 */

package org.szd.base.service.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzhen
 * @version 1.0
 * @since 1.0
 */


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.szd.base.entity.BaseArea;
import org.szd.base.service.BaseAreaService;
import org.work.platform.dao.BaseDao;
import org.work.platform.dao.support.Page;
import org.work.platform.service.impl.BaseServiceImpl;

@Service
public class BaseAreaServiceImpl extends BaseServiceImpl<BaseArea> implements BaseAreaService{
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "baseAreaDao")  
   public void setDao(BaseDao<BaseArea> dao) {  
       super.setDao(dao);  
   } 
   
	@Override
	public Page findPage(BaseArea baseArea, int pageSize, int pageNo) {
		Map<String,Object> values=new HashMap<String,Object>();
		return getPagedNamedQuery("base::BaseArea::findPage", pageNo, pageSize, values);
	}
   
}
