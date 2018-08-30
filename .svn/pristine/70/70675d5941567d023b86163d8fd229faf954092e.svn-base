package org.szd.base.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.szd.base.entity.BaseRole;
import org.szd.base.entity.BaseUser;
import org.szd.base.service.BaseRoleService;
import org.work.platform.dao.support.Page;
import org.work.util.PageUtil;

import redis.RedisUtil;

@Controller
@RequestMapping(value = "base/BaseRole")
public class BaseRoleController {
	@Autowired
	private BaseRoleService baseRoleService;

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
		BaseRole query = new BaseRole();
		query.setRoleName(searchValue);
		Page page = baseRoleService.findPage(query, pageSize, pageNo);
		request.setAttribute("dataList", page.getResult());
		PageUtil pm = new PageUtil(Long.valueOf(page.getTotalCount()).intValue(), pageSize, pageSize);
		pm.goToPage(pageNo);
		request.setAttribute("pageHtml", pm.getPageCode());
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("searchValue", searchValue);
		return "base/BaseRole/list";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, Model model) {
		return "base/BaseRole/add";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		BaseRole baseRole = baseRoleService.findById(id);
		request.setAttribute("baseRole", baseRole);
		return "base/BaseRole/edit";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public String save(BaseRole baseRole, HttpServletRequest request, Model model,
			RedirectAttributes redirectAttributes) {
		baseRole.setCreTime(new Date());
		baseRole.setModTime(new Date());
		baseRole.setCreUser(((BaseUser) request.getSession().getAttribute("wsBaseUser")).getId());
		baseRoleService.save(baseRole);
		baseRoleService.cacheOne(baseRole);
		return "success";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		BaseRole baseRole = baseRoleService.findById(id);
		String roleCode = baseRole.getRoleCode();
		baseRoleService.delete(baseRole);
		baseRoleService.delCacheOne(roleCode);
		return "success";
	}
}
