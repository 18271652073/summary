package com.test.summary.common.component.esconfig;

/**
 * ES 数据源常量
 * @author Administrator
 *
 */
public class ESDataSourceConstants {

	
	/**
	 * 缓存ES
	 */
	public static final String ES_CAHCE_TEMPLATE_BEAN_NAME = "Elasticsearch_Cache_Template";
	
	/**
	 * 搜索ES 
	 */
	public static final String ES_SEARCH_TEMPLATE_BEAN_NAME = "Elasticsearch_Search_Template";
	
	/**
	 * 作为NoSql的ES
	 * 该类型为默认的模板
	 * 直接 autowire 注入的就是该类型的模板
	 */
	public static final String ES_NOSQL_TEMPLATE_BEAN_NAME = "elasticsearchTemplate";
}
