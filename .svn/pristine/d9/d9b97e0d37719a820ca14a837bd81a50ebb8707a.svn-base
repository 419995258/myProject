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
import org.szd.base.service.BaseNoteService;
import org.szd.base.entity.BaseNote;
import org.work.platform.dao.support.Page;
import org.work.util.PageUtil;

import redis.RedisUtil;

@Controller
@RequestMapping(value = "base/BaseNote")
public class BaseNoteController {

	@Autowired
	private BaseNoteService baseNoteService;

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
		BaseNote baseNote = new BaseNote();
		Page page = baseNoteService.findPage(baseNote, pageSize, pageNo);
		request.setAttribute("dataList", page.getResult());
		PageUtil pm = new PageUtil(Long.valueOf(page.getTotalCount()).intValue(), pageSize, pageSize);
		pm.goToPage(pageNo);
		request.setAttribute("pageHtml", pm.getPageCode());
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("searchValue", searchValue);
		return "base/BaseNote/list";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, Model model) {
		return "base/BaseNote/add";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public String save(BaseNote baseNote, HttpServletRequest request, Model model) {
		baseNoteService.save(baseNote);
		return "success";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		BaseNote baseNote = baseNoteService.findById(id);
		request.setAttribute("baseNote", baseNote);
		return "base/BaseNote/edit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, Model model) {
		return "update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		baseNoteService.delete(id);
		return "success";
	}
}
