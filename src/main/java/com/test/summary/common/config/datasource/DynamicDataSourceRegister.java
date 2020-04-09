package com.test.summary.common.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.test.summary.common.utils.PropertiesLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源注册类
 *
 * @author kwj
 */
@Slf4j
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader loader = new PropertiesLoader("application.properties");

    /**
     * 指定默认数据源（springboot2.0默认数据源时hikari 如何想使用其他数据源可以自己配置） private static final String
     * DATASOURCE_TYPE_DEFAULT = "com.zaxxer.hikari.HikariDataSource";
     */
    private static final String DATASOURCE_TYPE_DEFAULT = "com.alibaba.druid.pool.DruidDataSource";
    /**
     * 默认数据源
     */
    private DataSource defaultDataSource;
    /**
     * 用户自定义数据源
     */
    private Map<String, Object> slaveDataSources = new HashMap<>();

    /**
     * 在设置环境中做了两件事 1.首先是初始化主数据源 2.初始化从数据源
     */
    @Override
    public void setEnvironment(Environment environment) {
        initDefaultDataSource(environment);
        initSlaveDataSource(environment);
    }

    /**
     * 初始化默认数据源.
     */
    private void initDefaultDataSource(Environment env) {
        //读取主数据源
        Map<String, Object> dsMap = new HashMap<>();
        dsMap.put("driver", env.getProperty("spring.datasource.driver-class-name"));
        dsMap.put("url", env.getProperty("spring.datasource.url"));
        dsMap.put("username", env.getProperty("spring.datasource.username"));
        dsMap.put("password", env.getProperty("spring.datasource.password"));
        defaultDataSource = buildDataSource(dsMap);
    }

    /**
     * 初始化从数据源.
     */
    private void initSlaveDataSource(Environment env) {
        //读取配置文件获取更多数据源
        String dsPrefixs = env.getProperty("slave.datasource.names");
        for (String dsPrefix : dsPrefixs.split(",")) {
            //多个数据源
            Map<String, Object> dsMap = new HashMap<>();
            dsMap.put("driver", env.getProperty("slave.datasource." + dsPrefix + ".driver-class-name"));
            dsMap.put("url", env.getProperty("slave.datasource." + dsPrefix + ".jdbc-url"));
            dsMap.put("username", env.getProperty("slave.datasource." + dsPrefix + ".username"));
            dsMap.put("password", env.getProperty("slave.datasource." + dsPrefix + ".password"));
            DataSource ds = buildDataSource(dsMap);
            slaveDataSources.put(dsPrefix, ds);
        }
    }


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        //添加默认数据源
        targetDataSources.put("dataSource", this.defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");
        //添加其他数据源
        targetDataSources.putAll(slaveDataSources);
        for (String key : slaveDataSources.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }

        //创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", targetDataSources);
        //注册 - BeanDefinitionRegistry
        registry.registerBeanDefinition("dataSource", beanDefinition);
        log.info("Dynamic DataSource Registry");
    }

    private DataSource buildDataSource(Map<String, Object> dataSourceMap) {
        try {
            Object type = dataSourceMap.get("type");
            if (null == type) {
                type = DATASOURCE_TYPE_DEFAULT;
            }
            Class<? extends DataSource> dataSourceType;
            dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);
            String driverClassName = dataSourceMap.get("driver").toString();
            String url = dataSourceMap.get("url").toString();
            String username = dataSourceMap.get("username").toString();
            String password = dataSourceMap.get("password").toString();

            //自定义配置
            DataSourceBuilder<? extends DataSource> factory = DataSourceBuilder.create()
                    .driverClassName(driverClassName)
                    .url(url)
                    .username(username)
                    .password(password)
                    .type(dataSourceType);
            //##########配置数据池信息#############
            DruidDataSource dataSource = (DruidDataSource) factory.build();
            // 配置初始化大小、最小、最大
            dataSource.setInitialSize(loader.getInteger("initialSize"));
            dataSource.setMinIdle(loader.getInteger("minIdle"));
            dataSource.setMaxActive(loader.getInteger("maxActive"));
            // 配置获取连接等待超时的时间
            dataSource.setMaxWait(loader.getLong("maxWait"));
            // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
            dataSource
                    .setTimeBetweenEvictionRunsMillis(loader.getLong("timeBetweenEvictionRunsMillis"));
            // 配置一个连接在池中最小生存的时间，单位是毫秒
            dataSource.setMinEvictableIdleTimeMillis(loader.getLong("minEvictableIdleTimeMillis"));
            dataSource.setValidationQuery(loader.getProperty("validationQuery"));
            dataSource.setTestWhileIdle(loader.getBoolean("testWhileIdle"));
            dataSource.setTestOnBorrow(loader.getBoolean("testOnBorrow"));
            dataSource.setTestOnReturn(loader.getBoolean("testOnReturn"));
            // 打开PSCache
            dataSource.setPoolPreparedStatements(loader.getBoolean("poolPreparedStatements"));
            // 指定每个连接上PSCache的大小
            dataSource.setMaxPoolPreparedStatementPerConnectionSize(
                    loader.getInteger("maxPoolPreparedStatementPerConnectionSize"));
//            try {
            // 配置监控统计拦截的filters，去掉后监控界面sql无法统计，‘wall‘用于防火墙
//                dataSource.setFilters(loader.getProperty("filters"));
//            } catch (SQLException e) {
//                log.error("druid configuration initialization filter", e);
//            }
            // 通过connectProperties属性来打开mergeSql功能；慢SQL记录
            dataSource.setConnectionProperties(loader.getProperty("connectionProperties"));
            // 合并多个DruidDataSource的监控数据
            dataSource.setUseGlobalDataSourceStat(true);
            return dataSource;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
