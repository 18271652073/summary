//package com.test.summary.common.config;
//
//import com.test.summary.service.WebService;
//import org.apache.cxf.Bus;
//import org.apache.cxf.jaxws.EndpointImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.xml.ws.Endpoint;
//
///**
// * @author Dukaixiang
// * @date 2019/9/18.
// */
//@Configuration
//public class CxfConfig {
//
//    @Autowired
//    private Bus bus;
//
//    @Autowired
//    private WebService webService;
//
////    @Bean
////    public ServletRegistrationBean dispatcherServlet() {
////        return new ServletRegistrationBean(new CXFServlet(),"/statistics/services/*");
////    }
//
//    @Bean
//    public Endpoint endpoint() {
//        EndpointImpl endpoint = new EndpointImpl(bus, webService);
//        endpoint.publish("/service");
//        return endpoint;
//    }
//}
