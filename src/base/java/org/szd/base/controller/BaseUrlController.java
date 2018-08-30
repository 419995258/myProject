/*
 * wangzhen
 * date 2017
 */

package org.szd.base.controller;

import java.util.*;

/**
 * @author wangzhen
 * @version 1.0
 * @since 1.0
 */

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.szd.base.service.BaseUrlService;
import org.szd.base.entity.BaseUrl;
import org.szd.base.entity.BaseUser;
import org.work.platform.dao.support.Page;
import org.work.util.PageUtil;

import redis.RedisUtil;

@Controller
@RequestMapping(value = "base/BaseUrl")
public class BaseUrlController {

	@Autowired
	private BaseUrlService baseUrlService;

	@Autowired
	private RedisUtil redisUtil;

	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(HttpServletRequest request, Model model) {
		String muId=request.getParameter("muId");
		request.setAttribute("moduleId", muId);
		int pageSize = 10;
		int pageNo = 1;
		if (request.getParameter("pageNo") != null && !request.getParameter("pageNo").equals("")) {
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		}
		String searchValue = request.getParameter("searchValue");
		if (searchValue == null) {
			searchValue = "";
		}
		BaseUrl baseUrl = new BaseUrl();
		baseUrl.setModuleId(muId);
		Page page = baseUrlService.findPage(baseUrl, pageSize, pageNo);
		request.setAttribute("dataList", page.getResult());
		PageUtil pm = new PageUtil(Long.valueOf(page.getTotalCount()).intValue(), pageSize, pageSize);
		pm.goToPage(pageNo);
		request.setAttribute("pageHtml", pm.getPageCode());
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("searchValue", searchValue);
		return "base/BaseUrl/list";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, Model model) {
		String moduleId=request.getParameter("moduleId");
		request.setAttribute("moduleId", moduleId);
		return "base/BaseUrl/add";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public String save(BaseUrl baseUrl, HttpServletRequest request, Model model) {
		baseUrl.setCreTime(new Date());
		baseUrl.setCreUser(((BaseUser) request.getSession().getAttribute("wsBaseUser")).getId());
		baseUrlService.save(baseUrl);
		return "success";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		BaseUrl baseUrl = baseUrlService.findById(id);
		request.setAttribute("baseUrl", baseUrl);
		return "base/BaseUrl/edit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, Model model) {
		return "update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		baseUrlService.delete(id);
		return "success";
	}
}
