package com.test.summary.common.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2018/9/20.
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource.secondary")
//引用爆红可能是其他地方也同样引用。后面的参数用‘-’拼接的可以驼峰表示。（2.2.5.RELEASE可用jdbcUrl、driverClassName）
@Data//必须进行get set才能使注解@ConfigurationProperties生效
public class ConfigValueComponent {
    public String driverClassName;
    public String jdbcUrl;
    public String username;
    public String password;

    public void ss() {
        System.out.println(jdbcUrl + "....." + username + "....." + password + "....." + driverClassName);
    }

}
