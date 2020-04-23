package com.test.summary.service;

import com.alibaba.fastjson.JSON;
import com.test.summary.common.component.esconfig.ESDataSourceConstants;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 2020/4/21.
 */
@Service
public class EsService {

//    @Autowired
//    @Qualifier(ESDataSourceConstants.ES_CAHCE_TEMPLATE_BEAN_NAME)
//    private ElasticsearchTemplate et;


//    public void getEs() {
//        CreateIndexRequestBuilder createIndexRequestBuilder = et.getClient().admin().indices()
//                .prepareCreate("ztest");
////        createIndexRequestBuilder.setSource(JSON.toJSONString(initSettings()), XContentType.JSON);
//        createIndexRequestBuilder.setSource(JSON.toJSONString(initSettings()));
//        createIndexRequestBuilder.execute().actionGet().isAcknowledged();
//    }

    /**
     * 获取动态Mapping
     */
    private static Map<String, Object> initSettings() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "string");
        map.put("index", "not_analyzed");

        //尝试了，没用。突破不了32766。解决不了报错
        /*
         * original message: bytes can be at most 32766 in length; got 52487
         * java.lang.IllegalArgumentException: Document contains at least one immense term in field="requestParam" (whose UTF8 encoding is longer than the max length 32766),
         */
//		map.put("ignore_above", "90000");

        Map<String, Object> enMap = new HashMap<String, Object>();
        enMap.put("match", "*");
        enMap.put("match_mapping_type", "string");
        enMap.put("mapping", map);
        Map<String, Object> tmpMap = new HashMap<String, Object>();
        tmpMap.put("en", enMap);
        Map<String, Object> defMap = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        list.add(tmpMap);
        defMap.put("dynamic_templates", list);
        defMap.put("date_detection", false);
        Map<String, Object> mappingsMap = new HashMap<String, Object>();
        mappingsMap.put("_default_", defMap);

        Map<String, Object> rootmap = new HashMap<String, Object>();
        rootmap.put("mappings", mappingsMap);
        return rootmap;
    }

}
