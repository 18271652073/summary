package com.test.summary;

//import com.test.summary.common.config.datasource.DynamicDataSourceRegister;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.test.summary.common.config.datasource.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
@Import({DynamicDataSourceRegister.class})
//@ImportResource("classpath:applicationContext-tx.xml")//TransactionConfig
@MapperScan("com.test.summary.dom.*.mapper")
@EnableTransactionManagement //开启事务管理
@Controller
@RequestMapping("discovery")
//@EnableDiscoveryClient
public class SummaryApplication {

    public static void main(String[] args) {
        System.setProperty("nacos.standalone", "true");
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(SummaryApplication.class, args);
        //http://localhost:8081/summary/services/service?wsdl
        //由于用的spring版本较低，server.servlet.context-path不生效所以不用summary
        System.out.println("http://localhost:8081/services/service?wsdl");
        System.out.println("http://localhost:8081/summary/swagger-ui.html");
    }

//    @NacosInjected
//    private NamingService namingService;

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

//    @PostConstruct
//    public void registerInstance() throws NacosException {
//        namingService.registerInstance(applicationName, "192.168.137.1", serverPort);
//    }

//    @RequestMapping(value = "/get", method = GET)
//    @ResponseBody
//    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
//        return namingService.getAllInstances(serviceName);
//    }


}
