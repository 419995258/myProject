package org.szd.base.service;

import org.szd.base.entity.BaseUser;

public interface LoginService {
	
	/**
	 * 执行登录操作
	 * @param loginName
	 * @param md5
	 * @return
	 */
	BaseUser login(String loginName, String pwd);
}
