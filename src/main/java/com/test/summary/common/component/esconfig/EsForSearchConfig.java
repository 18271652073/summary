//package com.test.summary.common.component.esconfig;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//
///**
// * ES多数据源配置--搜索ES
// * 使用前 先添加 配置 文件:
// * 	elasticsearch.enable=true
// *  elasticsearch.search.enable=true
// *  elasticsearch.search.cluster-name=elasticsearch
// *	elasticsearch.search.cluster-nodes=127.0.0.1:9300
// *	elasticsearch.search.client-transport-sniff=false
// * 使用时候添加 两个标注
// *  @Autowire
// *	@Qualifier(ESDataSourceConstants.ES_SEARCH_TEMPLATE_BEAN_NAME)
// *	private ElasticsearchTemplate  et;
// * @author ly
// * @date 2018年12月20日
// */
//@Configuration
//@ConditionalOnExpression("${elasticsearch.search.enable:false}")
//public class EsForSearchConfig {
//
//	private static final Logger logger = LoggerFactory.getLogger(EsForSearchConfig.class);
//
//	@Bean
//	@ConfigurationProperties("elasticsearch.search")
//	public EsTransportClientDataSourceProperties getSearchConfig() {
//		return new EsTransportClientDataSourceProperties();
//	}
//
//    /**ElasticsearchAutoConfiguration
//     * 搜索数据源
//     * 使用时候添加 两个标注
//     *  		@Autowired
//	 *			@Qualifier(ESDataSourceConstants.ES_SEARCH_TEMPLATE_BEAN_NAME)
//	 *			private ElasticsearchTemplate  et;
//     * @return ElasticsearchTemplate
//     * @throws Exception
//     */
//    @Bean(ESDataSourceConstants.ES_SEARCH_TEMPLATE_BEAN_NAME)
//    public ElasticsearchTemplate getCacheTemplate() throws Exception {
//    	EsTransportClientDataSourceProperties props = getSearchConfig();
//    	logger.info("%n初始化ES Search 数据源 ,ES信息为:[clusterName:"+props.getClusterName()+",clusterNodes:"+props.getClusterNodes()+"],如果您的项目中无需该数据源，请去掉elasticsearch.nosql.xx相关配置\r");
//    	props.buildClient();
//    	return new ElasticsearchTemplate(props.getObject());
//    }
//}
