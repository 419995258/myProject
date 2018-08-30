package myProject.esDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import myProject.User;

/**
 * ClassName: EsIndexDemo
 * @Description: TODO
 * @author pengbin 
 * @date  2018/2/26 11:54
 */
public class EsIndexDemo {

    /**
     *  同步获取操作结果
     */
    public static IndexResponse postRequest(String index, String type, String id, String jsonSource)
            throws Exception {
        // 构建请求
        IndexRequest request = new IndexRequest(index, type, id);
        // 将保存数据以JSON格式关联到请求
        request.source(jsonSource, XContentType.JSON);
        // Java客户端发起保存数据请求
        IndexResponse response = RestClientFactory.getHighLevelClient().index(request);
        // 等待结果
        System.out.println(response);
        return response;
    }
    /**
     * @param keyword1 关键字1
     * @param keyword2 关键字2
     * @param startDate 起始时间
     * @param endDate 终止时间
     *
     **/
    public  static SearchResponse pageQueryRequest(String keyword1, String keyword2, String startDate, String endDate,
                                                   int start, int size){
        RestHighLevelClient client = RestClientFactory.getHighLevelClient();

        // 这个sourcebuilder就类似于查询语句中最外层的部分。包括查询分页的起始，
        // 查询语句的核心，查询结果的排序，查询结果截取部分返回等一系列配置
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        // 结果开始处
        sourceBuilder.from(start);
        // 查询结果终止处
        sourceBuilder.size(size);
        // 查询的等待时间
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        MatchQueryBuilder matchbuilder;
        matchbuilder = QueryBuilders.matchQuery("message", keyword1+" "+keyword2);
        // 同时满足两个关键字
        matchbuilder.operator(Operator.AND);
        // 查询在时间区间范围内的结果
        RangeQueryBuilder rangbuilder = QueryBuilders.rangeQuery("date");
        if(!"".equals(startDate)){
            rangbuilder.gte(startDate);
        }
        if(!"".equals(endDate)){
            rangbuilder.lte(endDate);
        }
        // 等同于bool，将两个查询合并
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(matchbuilder);
        boolBuilder.must(rangbuilder);
        // 排序
        FieldSortBuilder fsb = SortBuilders.fieldSort("date");
        fsb.order(SortOrder.DESC);
        sourceBuilder.sort(fsb);

        sourceBuilder.query(boolBuilder);
        //System.out.println(sourceBuilder);
        SearchRequest searchRequest = new SearchRequest("request");
        searchRequest.types("doc");
        searchRequest.source(sourceBuilder);
        SearchResponse response = null;
        try {
            response = client.search(searchRequest);
            SearchHits hits= response.getHits();
            int totalRecordNum= (int) hits.getTotalHits();
            JSONObject json = new JSONObject();
            json.put("date","1995-05-16");
//            Gson gson = new GsonBuilder()
//                    .setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
//                    .create();
            for (SearchHit searchHit : hits) {
                Map<String, Object> source = searchHit.getSourceAsMap();
                User user = JSON.parseObject(json.toString(),User.class);
//                Object entity =gson.fromJson(gson.toJson(source),User.class);
                System.out.println(user);
            }


            client.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;
    }

    public static void main(String[] args) {
        String jsonString = "{" + "\"user\":\"xiefg\"," + "\"date\":\"2018-01-12\","
                + "\"message\":\"trying out Elasticsearch\"" + "}";
        try {
            for (int i=0;i<30;i++){
                postRequest("request", "doc", UUID.randomUUID()+"", jsonString);
            }
            RestClientFactory.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}