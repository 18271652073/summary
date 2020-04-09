//package com.test.summary.service;
//
//import javax.jws.WebMethod;
//import javax.jws.WebParam;
//import javax.jws.WebResult;
//
///**
// * @author Dukaixiang
// * 开发webservice接口需要CxfConfig配置
// * pom里的cxf包，spring半杯改成1.5.7.RELEASE
// * 由于版本降低很多spring的类引用不了，redis，jdbc的（DataSourceBuilder）等等
// * 最主要的是thymeleaf会报错meta未封闭，注解掉该pom的包或者配置文件：spring.thymeleaf.mode=LEGACYHTML5
// * EmbeddedServletContainerAutoConfiguration的报错需要注解上pom里的cxf
// * @date 2019/9/18.
// */
//@javax.jws.WebService(name = "WebService", // 暴露服务名称
//        targetNamespace = "http://service.summary.test.com"// 命名空间,一般是接口的包名倒序
//)
//public interface WebService {
//
//    @WebMethod
//    @WebResult(name = "String", targetNamespace = "")
//    String notice(@WebParam(name = "taskID") String taskID,
//                  @WebParam(name = "fromID") String fromID,
//                  @WebParam(name = "fileID") String fileID,
//                  @WebParam(name = "randomStr") String randomStr);
//
//    @WebMethod
//    @WebResult(name = "String", targetNamespace = "")
//    String download(@WebParam(name = "taskID") String tarkID,
//                    @WebParam(name = "fileID") String fileID,
//                    @WebParam(name = "randomStr") String randomStr);
//
//}
