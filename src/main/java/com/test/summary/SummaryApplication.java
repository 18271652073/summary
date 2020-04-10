package com.test.summary;

//import com.test.summary.common.config.datasource.DynamicDataSourceRegister;
import com.test.summary.common.config.datasource.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Import({DynamicDataSourceRegister.class})
@MapperScan("com.test.summary.dom.*.mapper")
@EnableTransactionManagement //开启事务管理
public class SummaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SummaryApplication.class, args);
        //http://localhost:8081/summary/services/service?wsdl
        //由于用的spring版本较低，server.servlet.context-path不生效所以不用summary
        System.out.println("http://localhost:8081/services/service?wsdl");
        System.out.println("http://localhost:8081/summary/swagger-ui.html");
    }

}
