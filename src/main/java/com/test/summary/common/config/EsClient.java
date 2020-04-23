//package com.test.summary.common.config;
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.stereotype.Component;
//
//import java.net.InetSocketAddress;
//
///**
// * @author Administrator
// * @date 2020/4/21.
// */
//@Component
//public class EsClient extends ElasticsearchTemplate {
//
//    private TransportClient client;
//
//    public EsClient(Client client) {
//        super(client);
//    }
//
//    public TransportClient getClient(){
//        Settings setting = Settings.builder()
//                .put("cluster.name", "elasticsearch")
//                .put("client.transport.ignore_cluster_name", true)
////                    .put("client.transport.nodes_sampler_interval", 5) //
//                .put("client.transport.sniff", false)
//                .build();
//
//        client = new PreBuiltTransportClient(setting)
//                .addTransportAddress(
//                        new TransportAddress(new InetSocketAddress("192.168.120.29",9300))
//                );
//        return  client;
//
//    }
//
//}
