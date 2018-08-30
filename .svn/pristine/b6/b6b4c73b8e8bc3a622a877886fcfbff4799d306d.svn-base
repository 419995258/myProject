/*
 * wangzhen
 * date 2017
 */

package org.szd.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.bind.v2.TODO;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author wangzhen
 * @version 1.0
 * @since 1.0
 */

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.IdsQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.work.util.PageUtil;

import redis.RedisUtil;

@Controller
@RequestMapping(value = "base/BaseLog")
public class BaseLogController {

	@Autowired
	private RestHighLevelClient rhlClient;

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

		// TODO: 2018/2/26 具体demo看下面的test系列

		// 查询语句的核心，查询结果的排序，查询结果截取部分返回等一系列配置
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		// 结果开始处
		sourceBuilder.from(pageSize*(pageNo-1));
		// 查询结果终止处
		sourceBuilder.size(pageSize);
		// 排序
		FieldSortBuilder fsb = SortBuilders.fieldSort("@timestamp");
        fsb.order(SortOrder.DESC);
		sourceBuilder.sort(fsb);

		//查询满足名字定义为className的，内容包含BaseLog的记录
		QueryBuilder queryBuilder=QueryBuilders.matchQuery("className", "BaseLog");

		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		//must代表and、should代表or、mustnot返回 没有字段或值为null或没有值的文档
		boolQuery.mustNot(queryBuilder);

		sourceBuilder.query(boolQuery);

		SearchRequest searchRequest = new SearchRequest("my_project*");
		searchRequest.types("doc");
		searchRequest.source(sourceBuilder);

		try {
			SearchResponse response = rhlClient.search(searchRequest);
			SearchHits searchHits=response.getHits();
			SearchHit[] searchHitList=searchHits.getHits();
			PageUtil pm = new PageUtil(searchHits.getTotalHits(), pageSize, pageSize);
			pm.goToPage(pageNo);
			request.setAttribute("pageHtml", pm.getPageCode());
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("searchValue", searchValue);
			request.setAttribute("dataList", searchHitList);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "base/BaseLog/list";
	}

	/**
	 *
	 * @Description: TODO  elasticSearch的基本查询使用方法
	 * @param
	 * @return
	 * @throws
	 * @author pb
	 * 2018/2/27 15:23
	 */
	@RequestMapping(value = "TestEsQuery", method = RequestMethod.POST)
	public void TestEsQuery(){
		System.out.println("ok");


		//精准查询（如果是数字）
		QueryBuilder queryBuilder1 = QueryBuilders.termQuery("546","BaseModule");

		//精准查询（如果是字母等，必须要有.keyword）
		QueryBuilder queryBuilder2 = QueryBuilders.termQuery("className.keyword","BaseModule");

		//模糊查询----->分别为单个和多个查询
		QueryBuilder queryBuilder3 = QueryBuilders.matchQuery("className","BaseLog");
		QueryBuilder queryBuilder4 = QueryBuilders.moreLikeThisQuery(new String[]{"className"}, new String[]{"BaseLog"}, null);

		//多条件查询 must代表and、should代表or、mustnot返回 没有字段或值为null或没有值的文档（只是举个例子如何使用，没考虑逻辑）
//		QueryBuilder queryBuilder = QueryBuilders.boolQuery()
//				.must(queryBuilder1)
//				.should(queryBuilder2)
//				.mustNot(queryBuilder3);


		// 查询语句的核心，查询结果的排序，查询结果截取部分返回等一系列配置
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		// 结果开始处
		sourceBuilder.from(1);
		// 查询结果终止处
		sourceBuilder.size(20);
		// 排序
		FieldSortBuilder fsb = SortBuilders.fieldSort("@timestamp");
		fsb.order(SortOrder.DESC);
		sourceBuilder.sort(fsb);
		sourceBuilder.query(queryBuilder3);

		SearchRequest searchRequest = new SearchRequest("my_project*");
		searchRequest.types("doc");
		searchRequest.source(sourceBuilder);

		try {
			SearchResponse response = rhlClient.search(searchRequest);
			SearchHits searchHits=response.getHits();
			SearchHit[] searchHitList=searchHits.getHits();
			//查询的数据查看只有在循环获取的getSourceAsMap后才能在debug中看到（不知道为什么），因此获取看下结构
			for (SearchHit fields : searchHitList) {
				Map<String,Object> map = fields.getSourceAsMap();
				//获取id
				System.out.println(fields.getId());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}


	/**
	 *
	 * @Description: TODO  elasticSearch的基本删除方法
	 * @param
	 * @return
	 * @throws
	 * @author pengbin
	 * 2018/2/27 16:14
	 */
    @RequestMapping(value = "TestEsDelete", method = RequestMethod.POST)
    public void TestEsDelete() {
        System.out.println("ok");

        //通过id删除分别需要三个参数：index,type,以及id
        DeleteRequest deleteRequest = new DeleteRequest("my_project-2018.02.27","doc","p0_w1WEBduW1QBK2RVV4");
        DeleteResponse response = null;
        try {
            response = rhlClient.delete(deleteRequest);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(response);
    }


    /**
     *
     * @Description: TODO  elasticSearch的基本更新方法
     * @param
     * @return
     * @throws
     * @author pengbin
     * 2018/2/27 16:14
     */
    @RequestMapping(value = "TestEsUpdate", method = RequestMethod.POST)
    public void TestEsUpdate() {
        System.out.println("ok");

        UpdateResponse response = null;
        try {
            UpdateRequest  updateRequest = new UpdateRequest("my_project-2018.02.27","doc","yE9a1mEBduW1QBK2zlVi");
            updateRequest.doc(JsonXContent.contentBuilder().startObject()
                    .field("className", "base") //把什么field更新成什么
                    .endObject());
            rhlClient.update(updateRequest).getGetResult();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(response);
    }

    /**
     *
     * @Description: TODO  elasticSearch的基本添加方法
     * @param
     * @return
     * @throws
     * @author pengbin
     * 2018/2/27 16:14
     */
    @RequestMapping(value = "TestEsAdd", method = RequestMethod.POST)
    public void TestEsAdd() {
        System.out.println("ok");
        IndexRequest indexRequest = new IndexRequest("my_project", "doc");
        JSONObject json = new JSONObject();
        json.put("className","test01");
        json.put("doMethod","test02");
        json.put("level","info");
        json.put("@timestamp", LocalDateTime.now());
        String source = json.toString();
        indexRequest.source(source, XContentType.JSON);
        try {
            rhlClient.index(indexRequest);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




        //查询证明有数据了
        QueryBuilder queryBuilder = QueryBuilders.termQuery("className","test01");
        SearchRequest searchRequest = new SearchRequest("my_project*");
        searchRequest.types("doc");

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(queryBuilder);
        searchRequest.source(sourceBuilder);

        try {
            SearchResponse response = rhlClient.search(searchRequest);
            SearchHits searchHits=response.getHits();
            SearchHit[] searchHitList=searchHits.getHits();
            //查询的数据查看只有在循环获取的getSourceAsMap后才能在debug中看到（不知道为什么），因此获取看下结构
            for (SearchHit fields : searchHitList) {
                Map<String,Object> map = fields.getSourceAsMap();
                //获取id
                System.out.println(fields.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
