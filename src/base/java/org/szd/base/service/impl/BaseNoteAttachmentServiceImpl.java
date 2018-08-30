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
import org.szd.base.entity.BaseNoteAttachment;
import org.szd.base.service.BaseNoteAttachmentService;
import org.work.platform.dao.BaseDao;
import org.work.platform.service.impl.BaseServiceImpl;
import org.work.platform.dao.support.Page;

@Service
public class BaseNoteAttachmentServiceImpl extends BaseServiceImpl<BaseNoteAttachment> implements BaseNoteAttachmentService{
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "baseNoteAttachmentDao")  
   public void setDao(BaseDao<BaseNoteAttachment> dao) {  
       super.setDao(dao);  
   } 
   
	@Override
	public Page findPage(BaseNoteAttachment baseNoteAttachment, int pageSize, int pageNo) {
		Map<String,Object> values=new HashMap<String,Object>();
		return getPagedNamedQuery("base::BaseNoteAttachment::findPage", pageNo, pageSize, values);
	}
   
}
