//package com.test.summary.common.component.esconfig;
//
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.util.Assert;
//
//import java.net.InetAddress;
//import java.util.Properties;
//
//import static org.apache.commons.lang.StringUtils.*;
//
///**
// * ES 数据源配置
// * @author ly
// *
// */
//public class EsTransportClientDataSourceProperties implements DisposableBean {
//
//	private static final Logger logger = LoggerFactory.getLogger(EsTransportClientDataSourceProperties.class);
//	private String clusterNodes = "127.0.0.1:9300";
//	private String clusterName = "elasticsearch";
//	//是否开启探针
//	private Boolean clientTransportSniff = true;
//	private Boolean clientIgnoreClusterName = Boolean.FALSE;
//	private String clientPingTimeout = "5s";
//	private String clientNodesSamplerInterval = "5s";
//	private TransportClient client;
//	private Properties properties;
//	static final String COLON = ":";
//	static final String COMMA = ",";
//
//	@Override
//	public void destroy() throws Exception {
//		try {
//			logger.info("Closing elasticSearch  client");
//			if (client != null) {
//				client.close();
//			}
//		} catch (final Exception e) {
//			logger.error("Error closing ElasticSearch client: ", e);
//		}
//	}
//
//
//	public TransportClient getObject(){
//		return client;
//	}
//
//
//
//	/*@Override
//	public void afterPropertiesSet() throws Exception {
//		buildClient();
//	}*/
//
//	public void buildClient() throws Exception {
//		/*if(StringUtils.isBlank(clusterNodes)) {
//			return;
//		}*/
//		client = TransportClient.builder().settings(settings()).build();
//		Assert.hasText(clusterNodes, "[Assertion failed] clusterNodes settings missing.");
//		for (String clusterNode : split(clusterNodes, COMMA)) {
//			String hostName = substringBeforeLast(clusterNode, COLON);
//			String port = substringAfterLast(clusterNode, COLON);
//			Assert.hasText(hostName, "[Assertion failed] missing host name in 'clusterNodes'");
//			Assert.hasText(port, "[Assertion failed] missing port in 'clusterNodes'");
//			logger.info("adding transport node : " + clusterNode);
//			client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(hostName), Integer.valueOf(port)));
//		}
//		client.connectedNodes();
//	}
//
//	private Settings settings() {
//		if (properties != null) {
//			return Settings.builder().put(properties).build();
//		}
//		return Settings.builder()
//				.put("cluster.name", clusterName)
//				.put("client.transport.sniff", clientTransportSniff)
//				.put("client.transport.ignore_cluster_name", clientIgnoreClusterName)
//				.put("client.transport.ping_timeout", clientPingTimeout)
//				.put("client.transport.nodes_sampler_interval", clientNodesSamplerInterval)
//				.build();
//	}
//
//	public void setClusterNodes(String clusterNodes) {
//		this.clusterNodes = clusterNodes;
//	}
//
//	public void setClusterName(String clusterName) {
//		this.clusterName = clusterName;
//	}
//
//	public void setClientTransportSniff(Boolean clientTransportSniff) {
//		this.clientTransportSniff = clientTransportSniff;
//	}
//
//	public String getClientNodesSamplerInterval() {
//		return clientNodesSamplerInterval;
//	}
//
//	public void setClientNodesSamplerInterval(String clientNodesSamplerInterval) {
//		this.clientNodesSamplerInterval = clientNodesSamplerInterval;
//	}
//
//	public String getClientPingTimeout() {
//		return clientPingTimeout;
//	}
//
//	public void setClientPingTimeout(String clientPingTimeout) {
//		this.clientPingTimeout = clientPingTimeout;
//	}
//
//	public Boolean getClientIgnoreClusterName() {
//		return clientIgnoreClusterName;
//	}
//
//	public void setClientIgnoreClusterName(Boolean clientIgnoreClusterName) {
//		this.clientIgnoreClusterName = clientIgnoreClusterName;
//	}
//
//	public void setProperties(Properties properties) {
//		this.properties = properties;
//	}
//
//
//
//
//
//	public String getClusterNodes() {
//		return clusterNodes;
//	}
//
//
//	public String getClusterName() {
//		return clusterName;
//	}
//
//
//}
