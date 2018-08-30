package org.szd.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.szd.base.entity.BaseUser;
import org.szd.base.service.LoginService;
import org.work.platform.dao.BaseDao;
import org.work.platform.service.impl.BaseServiceImpl;

@Service
public class LoginServiceImpl extends BaseServiceImpl<BaseUser> implements LoginService {
	
    /** 
    * 注入DAO 
    */  
   @Resource(name = "baseUserDao")  
   public void setDao(BaseDao<BaseUser> dao) {  
       super.setDao(dao);  
   }

	@SuppressWarnings("unchecked")
	@Override
	public BaseUser login(String loginName, String pwd) {
		//String hql = "from BaseUser where (/~ loginName = {loginName} ~//~ or email = {email}~//~ or mobile = {mobile}~/)/~ and password = {password}~/ and deleteFlag='0' and status='1'";
		Map<String,Object> values=new HashMap<String,Object>();
		values.put("loginName", loginName);
		values.put("email", loginName);
		values.put("mobile", loginName);
		values.put("password", pwd);
		List<BaseUser> list =getNamedQuery("base::BaseUser::login", values);
		if (list.size() == 0) { // 用户不存在
			return null;
		} else { // 用户存在
			BaseUser usr = list.get(0);
			return usr;
		}
	}

}
