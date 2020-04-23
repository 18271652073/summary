//package com.test.summary.common.component.esconfig;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
//
//
///**
// * ES多数据源配置--nosql  ElasticsearchAutoConfiguration
// * 该数据源 会覆盖默认  elasticsearchTemplate  bean,
// * 如果没有定制 elasticsearchTemplate 该elasticsearchTemplate 与spring提供的 是一样的
// *  使用前 先添加 配置 文件:
// *  elasticsearch.enable=true
// *  elasticsearch.nosql.cluster-name=elasticsearch
// *	elasticsearch.nosql.cluster-nodes=127.0.0.1:9300
// *	elasticsearch.nosql.client-transport-sniff=false
// * 使用时候添加 两个标注
// *  @Autowire
// *	@Qualifier(ESDataSourceConstants.ES_NOSQL_TEMPLATE_BEAN_NAME)
// *	private ElasticsearchTemplate  et;
// * @author ly
// * @date 2018年12月20日
// */
//@Configuration
//@ConditionalOnExpression("${elasticsearch.enable:false}")
//public class EsForNosqlConfig {
//
//	private static final Logger logger = LoggerFactory.getLogger(EsForNosqlConfig.class);
//
//	@Bean
//	@Primary
//    @ConfigurationProperties("elasticsearch.nosql")
//	public EsTransportClientDataSourceProperties getNosqlConfig() {
//		return new EsTransportClientDataSourceProperties();
//	}
//
//
//    @Primary
//    @Bean(ESDataSourceConstants.ES_NOSQL_TEMPLATE_BEAN_NAME)
//    public ElasticsearchTemplate getNosqlTemplate(ElasticsearchConverter converter) throws Exception {
//        //return new ElasticsearchTemplate(nodeBuilder().local(true).node().client());
//    	EsTransportClientDataSourceProperties props = getNosqlConfig();
//    	/*if(StringUtils.isBlank(props.getClusterNodes())) {
//    		try {
//    			EsCacheEnable esCacheEnable = (EsCacheEnable) ServiceLocator.getInstance().getCtx().getBean("esCacheEnable");
//    			props = esCacheEnable.getCacheConfig();
//			} catch (Exception e) {
//			}
//    	}
//    	if(StringUtils.isBlank(props.getClusterNodes())) {
//    		try {
//    			EsForSearchConfig esForSearchConfig = (EsForSearchConfig) ServiceLocator.getInstance().getCtx().getBean("esForSearchConfig");
//    			props = esForSearchConfig.getSearchConfig();
//			} catch (Exception e) {
//			}
//    	}*/
//    	logger.info("%n初始化Nosql数据源 ,ES信息为:[clusterName:"+props.getClusterName()+",clusterNodes:"+props.getClusterNodes()+"],如果您的项目中无需该数据源，请去掉elasticsearch.nosql.xxx配置\\r");
//    	props.buildClient();
//    	return new ElasticsearchTemplate(props.getObject(),converter);
//	}
//}
