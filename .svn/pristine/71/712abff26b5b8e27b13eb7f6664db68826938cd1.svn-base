package org.szd.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.szd.base.entity.BaseUser;
import org.szd.base.service.BaseQueryService;
import org.szd.base.service.LoginService;
import org.work.util.EncryptUtils;
import org.work.util.LogUtil;
import org.work.util.MD5;

import redis.RedisUtil;

@Controller
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private BaseQueryService baseQueryService;

	@Autowired
	private RedisUtil redisUtil;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> login(HttpServletRequest request, Model model) {
		Map<String, String> returnMap = new HashMap<String, String>();

		String loginName = request.getParameter("inputLogin") == null ? "" : request.getParameter("inputLogin").trim();
		String password = request.getParameter("inputPwd");
		String inputRand = request.getParameter("inputRand");
		String rand = (String) request.getSession().getAttribute("rand");

		if (inputRand == null || !inputRand.equals(rand)) {
			returnMap.put("errorType", "ImageChkFailed");
			return returnMap;
		}

		try {
			loginName = EncryptUtils.aesDecrypt(loginName);
			password = EncryptUtils.aesDecrypt(password);
		} catch (Exception e1) {
		}

		BaseUser baseUser = null;
		if (baseUser == null) {
			baseUser = loginService.login(loginName, MD5.getMd5(password));
		}

		if (baseUser == null) {
			returnMap.put("errorType", "UserInactive");
		} else {
			if (baseUser.getStatus() != null && baseUser.getStatus().equals("0")) {
				returnMap.put("errorType", "UserInactiveStatus");
			} else {
				request.getSession().setAttribute("wsUserId", baseUser.getId());
				request.getSession().setAttribute("wsAreaId", baseUser.getAreaId());
				request.getSession().setAttribute("wsLoginName", baseUser.getLoginName());
				request.getSession().setAttribute("wsRealName", baseUser.getRealname());
				request.getSession().setAttribute("wsBaseUser", baseUser);
				request.getSession().setAttribute("wsSchoolId", baseUser.getSchoolId());
				request.getSession().setAttribute("wsDefaultRoleCode", baseUser.getDefaultRoleCode());
				returnMap.put("errorType", "success");
			}
		}

		return returnMap;
	}

	@RequestMapping(value = "init", method = RequestMethod.GET)
	public void init() {
		baseQueryService.initCache();
	}
}
