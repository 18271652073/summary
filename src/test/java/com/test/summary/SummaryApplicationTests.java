//package com.test.summary;
//
////import org.junit.jupiter.api.Test;
//
//import com.alibaba.fastjson.JSON;
//import com.test.summary.common.config.EsClient;
//import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.Client;
//import org.elasticsearch.common.xcontent.XContentType;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.SearchHits;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SummaryApplicationTests {
//
//    @Autowired
//    private EsClient esClient;
////    @Autowired(required=true)
////    private ElasticsearchTemplate elasticsearchTemplate;
//
////    @Autowired
////    @Qualifier("Elasticsearch_Cache_Template")
////    private ElasticsearchTemplate et;
////    private final static Map<String, Object> settings = initSettings();
//
////    @Test
////    public void contextLoads() {
////        CreateIndexRequestBuilder createIndexRequestBuilder = et.getClient().admin().indices()
////                .prepareCreate("ztest");
////        createIndexRequestBuilder.setSource(JSON.toJSONString(settings), XContentType.JSON);
////        createIndexRequestBuilder.execute().actionGet().isAcknowledged();
////    }
//
//
//    @Test
//    public void test1() {
//        System.out.println("12312");
////        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
////                .must(QueryBuilders.matchQuery("newsTitle", "首个电商俱乐部"))
////                .must(QueryBuilders.matchQuery("newsCate", "科技"));
////        Client client = elasticsearchTemplate.getClient();
////        SearchResponse response = client.prepareSearch("test")
////                .setTypes("newsArticle")
////                .setQuery(queryBuilder).get();
////        SearchHits searchHits = response.getHits();
////        for (SearchHit searchHit : searchHits) {
////            System.out.println(searchHit);
////        }
////        client.close();
//    }
//
//    /**
//     * 获取动态Mapping
//     */
//    private static Map<String, Object> initSettings() {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("type", "string");
//        map.put("index", "not_analyzed");
//
//        //尝试了，没用。突破不了32766。解决不了报错
//        /*
//         * original message: bytes can be at most 32766 in length; got 52487
//         * java.lang.IllegalArgumentException: Document contains at least one immense term in field="requestParam" (whose UTF8 encoding is longer than the max length 32766),
//         */
////		map.put("ignore_above", "90000");
//
//        Map<String, Object> enMap = new HashMap<String, Object>();
//        enMap.put("match", "*");
//        enMap.put("match_mapping_type", "string");
//        enMap.put("mapping", map);
//        Map<String, Object> tmpMap = new HashMap<String, Object>();
//        tmpMap.put("en", enMap);
//        Map<String, Object> defMap = new HashMap<String, Object>();
//        List<Object> list = new ArrayList<Object>();
//        list.add(tmpMap);
//        defMap.put("dynamic_templates", list);
//        defMap.put("date_detection", false);
//        Map<String, Object> mappingsMap = new HashMap<String, Object>();
//        mappingsMap.put("_default_", defMap);
//
//        Map<String, Object> rootmap = new HashMap<String, Object>();
//        rootmap.put("mappings", mappingsMap);
//        return rootmap;
//    }
//
//}
