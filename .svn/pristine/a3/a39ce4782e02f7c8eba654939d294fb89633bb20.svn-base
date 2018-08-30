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
import org.szd.base.service.BaseRoleUrlMapService;
import org.szd.base.entity.BaseRoleUrlMap;
import org.work.platform.dao.support.Page;
import org.work.util.PageUtil;

import redis.RedisUtil;

@Controller
@RequestMapping(value = "base/BaseRoleUrlMap")
public class BaseRoleUrlMapController {

	@Autowired
	private BaseRoleUrlMapService baseRoleUrlMapService;

	@Autowired
	private RedisUtil redisUtil;

	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(HttpServletRequest request, Model model) {
		int pageSize = 10;
		int pageNo = 1;
		if (request.getParameter("pageNo") != null && !request.getParameter("pageNo").equals("")) {
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		}
		String searchValue = request.getParameter("searchValue");
		if (searchValue == null) {
			searchValue = "";
		}
		BaseRoleUrlMap baseRoleUrlMap = new BaseRoleUrlMap();
		Page page = baseRoleUrlMapService.findPage(baseRoleUrlMap, pageSize, pageNo);
		request.setAttribute("dataList", page.getResult());
		PageUtil pm = new PageUtil(Long.valueOf(page.getTotalCount()).intValue(), pageSize, pageSize);
		pm.goToPage(pageNo);
		request.setAttribute("pageHtml", pm.getPageCode());
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("searchValue", searchValue);
		return "base/BaseRoleUrlMap/list";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, Model model) {
		return "base/BaseRoleUrlMap/add";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public String save(BaseRoleUrlMap baseRoleUrlMap, HttpServletRequest request, Model model) {
		baseRoleUrlMapService.save(baseRoleUrlMap);
		return "success";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		BaseRoleUrlMap baseRoleUrlMap = baseRoleUrlMapService.findById(id);
		request.setAttribute("baseRoleUrlMap", baseRoleUrlMap);
		return "base/BaseRoleUrlMap/edit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, Model model) {
		return "update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		baseRoleUrlMapService.delete(id);
		return "success";
	}
}
