package com.test.summary.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.test.summary.dom.sqlserver.mapper", sqlSessionTemplateRef = "sqlSessionTemplateSqlServer")
public class SqlServerDataSourceConfig {

    /**
     * 生成数据源.  @Primary 注解声明为默认数据源
     */
    @Bean(name = "dataSourceSqlServer")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    @Primary
    public DataSource dataSourceSqlServer() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建 SqlSessionFactory
     */
    @Bean(name = "sqlSessionFactorySqlServer")
    @Primary
    public SqlSessionFactory sqlSessionFactorySqlServer(@Qualifier("dataSourceSqlServer") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/test/summary/dom/sqlserver/mapper/*.xml"));
        return bean.getObject();
    }

    /**
     * 配置事务管理
     */
    @Bean(name = "transactionManagerSqlServer")
    @Primary
    public DataSourceTransactionManager transactionManagerSqlServer(@Qualifier("dataSourceSqlServer") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplateSqlServer")
    @Primary
    public SqlSessionTemplate sqlSessionTemplateSqlServer(@Qualifier("sqlSessionFactorySqlServer") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

