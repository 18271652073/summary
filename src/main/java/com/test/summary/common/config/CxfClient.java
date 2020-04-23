//package com.test.summary.common.config;
//
//import com.sap.document.sap.rfc.functions.ZFMB2BMM008;
//import com.sap.document.sap.rfc.functions.ZFMB2BMM008Response;
//import com.sap.document.sap.rfc.functions.ZSSDKFGL;
//import org.apache.cxf.endpoint.Client;
//import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
//import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
//
///**
// * @ClassName:CxfClient
// * @Description:webservice客户端： 该类提供两种不同的方式来调用webservice服务
// * 1：代理工厂方式
// * 2：动态调用webservice
// */
//public class CxfClient {
//
//
//    public static void main(String[] args) {
//        CxfClient.main2();
//    }
//
////    /**
////     * 1.代理类工厂的方式,需要拿到对方的接口地址
////     */
////    public static void main1() {
////        try {
////            // 接口地址
////            String address = "http://127.0.0.1/soap/user?wsdl";
////            // 代理工厂
////            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
////            // 设置代理地址
////            jaxWsProxyFactoryBean.setAddress(address);
////            // 设置接口类型
////            jaxWsProxyFactoryBean.setServiceClass(UserService.class);
////            // 创建一个代理接口实现//UserService是cxf生成的servcie
////            UserService us = (UserService) jaxWsProxyFactoryBean.create();
////            // 数据准备
////            String userId = "maple";
////            // 调用代理接口的方法调用并返回结果
////            String result = us.getUserName(userId);
////            System.out.println("返回结果:" + result);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//    /**
//     * 2：动态调用
//     */
//    public static void main2() {
//        // 创建动态客户端
//        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//        Client client = dcf.createClient("http://192.168.112.61:8000/sap/bc/soap/WSdl/?services=ZFM_B2B_MM_008");
//        // 需要密码的情况需要加上用户名和密码
//        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
//        Object[] objects = new Object[0];
//        try {
//            ZFMB2BMM008 zfmb2BMM008 = new ZFMB2BMM008();
//            zfmb2BMM008.setTEXTFIELD54431("3100365767");
//            zfmb2BMM008.setTEXTFIELD52971("");
//            // invoke("方法名",参数1,参数2,参数3....);
//            objects = client.invoke("ZFM_B2B_MM_008", zfmb2BMM008);//调用方法
//            ZFMB2BMM008Response response = (ZFMB2BMM008Response) objects[0];
//            ZSSDKFGL gsztsdkfgl = response.getGSZTSDKFGL();
//            System.out.println("返回数据:" + gsztsdkfgl);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main3() throws Exception {
//        System.setProperty("javax.net.ssl.trustStore", System.getProperty("user.dir") + "/src/main/resources/project.keystore"); //key路径
//        System.setProperty("javax.net.ssl.trustStorePassword", "12345678");//密码
//        System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
//        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//
//        DynamicClientFactory factory = DynamicClientFactory.newInstance();
//        Client client = factory.createClient("http://192.168.112.61:8000/sap/bc/soap/WSdl/?services=ZFM_B2B_MM_008");//生产的地址192.168.112.61，测试的192.168.112.71
//        ZFMB2BMM008 zfmb2BMM008 = new ZFMB2BMM008();
//        zfmb2BMM008.setTEXTFIELD54431("3100365767");
//        zfmb2BMM008.setTEXTFIELD52971("");
//        Object[] results = client.invoke("ZFM_B2B_MM_008", zfmb2BMM008);//调用方法
//        ZFMB2BMM008Response response = (ZFMB2BMM008Response) results[0];
//        ZSSDKFGL gsztsdkfgl = response.getGSZTSDKFGL();
//        System.out.println(gsztsdkfgl.toString());
//    }
//
//    public static void main4() throws Exception {
//        //创建动态客户端
//        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
//        Client client = factory.createClient("http://localhost:8090/demo/api?wsdl");
//        // 需要密码的情况需要加上用户名和密码
//        //client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
//        HTTPConduit conduit = (HTTPConduit) client.getConduit();
//        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
//        httpClientPolicy.setConnectionTimeout(2000);  //连接超时
//        httpClientPolicy.setAllowChunking(false);    //取消块编码
//        httpClientPolicy.setReceiveTimeout(120000);     //响应超时
//        conduit.setClient(httpClientPolicy);
//        //client.getOutInterceptors().addAll(interceptors);//设置拦截器
//        try{
//        Object[] objects = new Object[0];
//        // invoke("方法名",参数1,参数2,参数3....);
//        objects = client.invoke("sayHello", "sujin");
//        System.out.println("返回数据:" + objects[0]);
//        }catch (Exception e){
//        e.printStackTrace();
//        }
//    }
//}
