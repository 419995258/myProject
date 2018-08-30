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
import org.szd.base.entity.BaseNote;
import org.szd.base.service.BaseNoteService;
import org.work.platform.dao.BaseDao;
import org.work.platform.service.impl.BaseServiceImpl;
import org.work.platform.dao.support.Page;

@Service
public class BaseNoteServiceImpl extends BaseServiceImpl<BaseNote> implements BaseNoteService{
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "baseNoteDao")  
   public void setDao(BaseDao<BaseNote> dao) {  
       super.setDao(dao);  
   } 
   
	@Override
	public Page findPage(BaseNote baseNote, int pageSize, int pageNo) {
		Map<String,Object> values=new HashMap<String,Object>();
		return getPagedNamedQuery("base::BaseNote::findPage", pageNo, pageSize, values);
	}
   
}
