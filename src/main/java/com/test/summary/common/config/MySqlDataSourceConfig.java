//package com.test.summary.common.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = "com.test.summary.dom.mysql.mapper", sqlSessionTemplateRef = "sqlSessionTemplateMySql")
//public class MySqlDataSourceConfig {
//
//    /**
//     * 生成数据源.  @Primary 注解声明为默认数据源
//     */
//    @Bean(name = "dataSourceMySql")
//    @ConfigurationProperties(prefix = "spring.datasource.secondary")
//    public DataSource dataSourceMySql() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     * 创建 SqlSessionFactory
//     */
//    @Bean(name = "sqlSessionFactoryMySql")
//    @Qualifier("sqlSessionFactoryMySql")
//    public SqlSessionFactory sqlSessionFactoryMySql(@Qualifier("dataSourceMySql") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/test/summary/dom/mysql/mapper/*.xml"));
//        return bean.getObject();
//    }
//
//    /**
//     * 配置事务管理
//     */
//    @Bean(name = "transactionManagerMySql")
//    @Qualifier("transactionManagerMySql")
//    public DataSourceTransactionManager transactionManagerMySql(@Qualifier("dataSourceMySql") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "sqlSessionTemplateMySql")
//    @Qualifier("sqlSessionTemplateMySql")
//    public SqlSessionTemplate sqlSessionTemplateMySql(@Qualifier("sqlSessionFactoryMySql") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
//
