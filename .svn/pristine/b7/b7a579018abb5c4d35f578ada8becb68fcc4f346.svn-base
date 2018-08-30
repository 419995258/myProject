/*
 * wangzhen
 * date 2017
 */

package org.szd.base.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.szd.base.entity.BaseModule;
import org.szd.base.entity.BaseUser;
import org.szd.base.service.BaseModuleService;
import org.work.platform.dao.support.Page;
import org.work.util.PageUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.RedisUtil;

@Controller
@RequestMapping(value = "base/BaseModule")
public class BaseModuleController {

	@Autowired
	private BaseModuleService baseModuleService;

	@Autowired
	private RedisUtil redisUtil;

	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(HttpServletRequest request, Model model) {
		String queryParentCode=request.getParameter("queryParentCode");
		request.setAttribute("queryParentCode", queryParentCode);
		int pageSize = 10;
		int pageNo = 1;
		if (request.getParameter("pageNo") != null && !request.getParameter("pageNo").equals("")) {
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		}
		String searchValue = request.getParameter("searchValue");
		if (searchValue == null) {
			searchValue = "";
		}
		BaseModule baseModule = new BaseModule();
		baseModule.setParentCode(queryParentCode);
		Page page = baseModuleService.findPage(baseModule, pageSize, pageNo);
		request.setAttribute("dataList", page.getResult());
		PageUtil pm = new PageUtil(Long.valueOf(page.getTotalCount()).intValue(), pageSize, pageSize);
		pm.goToPage(pageNo);
		request.setAttribute("pageHtml", pm.getPageCode());
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("searchValue", searchValue);
		return "base/BaseModule/list";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, Model model) {
		request.setAttribute("queryParentCode", request.getParameter("queryParentCode"));
		return "base/BaseModule/add";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public String save(BaseModule baseModule, HttpServletRequest request, Model model) {
		String mNodeType=request.getParameter("mNodeType");
		baseModule.setNodeType(mNodeType);
		baseModule.setCreTime(new Date());
		baseModule.setCreUser(((BaseUser) request.getSession().getAttribute("wsBaseUser")).getId());
		baseModuleService.save(baseModule);
		return "success";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		BaseModule baseModule = baseModuleService.findById(id);
		request.setAttribute("baseModule", baseModule);
		return "base/BaseModule/edit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, Model model) {
		return "update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		baseModuleService.delete(id);
		return "success";
	}
	
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request, Model model) {
		List<BaseModule> moduleList=baseModuleService.findAll("creTime",true);
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String,String>> treeJson=new ArrayList<Map<String,String>>();
		Map<String,String> treeMapRoot=new HashMap<String,String>();
		treeMapRoot.put("id", "-1");
		treeMapRoot.put("pId", "1");
		treeMapRoot.put("name","模块");
		treeMapRoot.put("open","true");
		treeMapRoot.put("isParent","true");
		treeMapRoot.put("nodeType", "1");
		treeJson.add(treeMapRoot);
		for(BaseModule baseModule:moduleList){
			Map<String,String> treeMap=new HashMap<String,String>();
			treeMap.put("id", baseModule.getCode());
			treeMap.put("pId", baseModule.getParentCode());
			treeMap.put("name", baseModule.getModuleName());
			treeMap.put("nodeType", baseModule.getNodeType());
			treeMap.put("moduleId", baseModule.getId());
			if(baseModule.getNodeType().equals("1")){
				treeMapRoot.put("isParent","true");
			}else{
				treeMapRoot.put("isParent","false");
			}
			treeJson.add(treeMap);
		}
		try {
			String json = mapper.writeValueAsString(treeJson);
			request.setAttribute("treeJson", json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "base/BaseModule/index";
	}
}
