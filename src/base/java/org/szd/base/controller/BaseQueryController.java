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
import org.szd.base.entity.BaseQuery;
import org.szd.base.entity.BaseUser;
import org.szd.base.service.BaseQueryService;
import org.work.platform.dao.support.Page;
import org.work.util.PageUtil;

import redis.RedisUtil;

@Controller
@RequestMapping(value = "base/BaseQuery")
public class BaseQueryController {

	@Autowired
	private BaseQueryService baseQueryService;

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
		BaseQuery query = new BaseQuery();
		query.setQueryName(searchValue);
		Page page = baseQueryService.findPage(query, pageSize, pageNo);
		request.setAttribute("dataList", page.getResult());
		PageUtil pm = new PageUtil(Long.valueOf(page.getTotalCount()).intValue(), pageSize, pageSize);
		pm.goToPage(pageNo);
		request.setAttribute("pageHtml", pm.getPageCode());
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("searchValue", searchValue);
		return "base/BaseQuery/list";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, Model model) {
		return "base/BaseQuery/add";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		BaseQuery baseQuery = baseQueryService.findById(id);
		request.setAttribute("baseQuery", baseQuery);
		return "base/BaseQuery/edit";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public String save(BaseQuery baseQuery, HttpServletRequest request, Model model,
			RedirectAttributes redirectAttributes) {
		baseQuery.setCreTime(new Date());
		baseQuery.setCreUser(((BaseUser) request.getSession().getAttribute("wsBaseUser")).getId());
		baseQuery.setDbType("oracle");
		baseQueryService.save(baseQuery);
		baseQueryService.cacheOne(baseQuery);
		return "success";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		BaseQuery baseQuery = baseQueryService.findById(id);
		String queryName = baseQuery.getQueryName();
		baseQueryService.delete(baseQuery);
		baseQueryService.delCacheOne(queryName);
		return "success";
	}
}
