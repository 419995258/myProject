/*
 * wangzhen
 * date 2017
 */

package org.szd.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangzhen
 * @version 1.0
 * @since 1.0
 */


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szd.base.entity.BaseModule;
import org.szd.base.service.BaseModuleService;
import org.work.platform.dao.BaseDao;
import org.work.platform.dao.support.Page;
import org.work.platform.service.impl.BaseServiceImpl;

@Service
public class BaseModuleServiceImpl extends BaseServiceImpl<BaseModule> implements BaseModuleService{
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "baseModuleDao")  
   public void setDao(BaseDao<BaseModule> dao) {  
       super.setDao(dao);  
   } 
   
	@Override
	public void onValid(BaseModule entity) {

		if (entity.getId() == null) {
			String array[] = getCodeArray(entity.getParentCode());
			entity.setCode(array[0]);
		}
	}
   
	@Override
	public Page findPage(BaseModule baseModule, int pageSize, int pageNo) {
		Map<String,Object> values=new HashMap<String,Object>();
		if(isNotEmpty(baseModule.getParentCode())) {
			values.put("parentCode", baseModule.getParentCode());
		}
		return getPagedNamedQuery("base::BaseModule::findPage", pageNo, pageSize, values);
	}
	
	public String[] getCodeArray(String code) {
		String[] array = { "", "" };
		String newCode = "";
		String parentCode = "";
		if (getMaxChildCodeByParent("-1").equals("")) {
			newCode = "000001";
			parentCode = "-1";
		} else if (code.equals("-1")) {
			String maxCode = getMaxChildCodeByParent("-1");
			int maxCodeInt = Integer.parseInt(maxCode);
			maxCodeInt++;
			String temp_str = String.valueOf(maxCodeInt);
			if (temp_str.length() < 6) {
				int count = temp_str.length();
				while (count < 6) {
					temp_str = "0" + temp_str;
					count++;
				}
				newCode = temp_str;
				parentCode = "-1";
			}
		} else {
			parentCode = code;
			String maxChildCode = getMaxChildCodeByParent(parentCode);

			if (maxChildCode.equals("")) {
				newCode = parentCode + "000001";
			} else {
				int maxChildCodeInt = Integer
						.parseInt(maxChildCode.substring(
								maxChildCode.length() - 6,
								maxChildCode.length()));
				maxChildCodeInt++;
				String temp_str = String.valueOf(maxChildCodeInt);
				if (temp_str.length() < 6) {
					int count = temp_str.length();
					while (count < 6) {
						temp_str = "0" + temp_str;
						count++;
					}
				}
				newCode = parentCode + temp_str;
			}
		}

		array[0] = newCode;
		array[1] = parentCode;

		return array;
	}
   
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getMaxChildCodeByParent(String parentCode) {
		Map<String,Object> values=new HashMap<String,Object>();
		if(isNotEmpty(parentCode)) {
			values.put("parentCode", parentCode);
		}
		List list=this.getNamedQuery("base::BaseModule::getMaxChildCodeByParent", values);
		if(list!=null&&list.size()==1){
			Object maxCode=((Map<String,Object>)(list.get(0))).get("MAX_CODE");
			if(isNotEmpty(maxCode)){
				return maxCode.toString();
			}
		}
		return "";
	}
}
