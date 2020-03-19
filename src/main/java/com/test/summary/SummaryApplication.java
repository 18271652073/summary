package com.test.summary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.test.summary.dom.*.mapper")
@EnableTransactionManagement //开启事务管理
public class SummaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SummaryApplication.class, args);
    }

}
