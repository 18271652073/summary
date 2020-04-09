package com.test.summary.common.config.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author caiChaoqi
 * @Description 动态数据源通知
 * @Date 2018-06-23
 */
@Aspect
@Order(1) //保证在@Transactional之前执行,越小越先
@Component
@Slf4j
public class DynamicDataSourceAspect {

    @Pointcut("@annotation(com.test.summary.common.config.datasource.TargetDataSource)")
    public void dataSourcePointCut() {
    }

    //改变数据源
    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        String dbid = targetDataSource.name();

        if (!DynamicDataSourceContextHolder.isContainDataSource(dbid)) {
            //joinPoint.getSignature() ：获取连接点的方法签名对象
            log.error("数据源 " + dbid + " 不存在使用默认的数据源 -> " + joinPoint.getSignature());
        } else {
            log.debug("使用数据源：" + dbid);
            DynamicDataSourceContextHolder.setDataSourceType(dbid);
        }
    }

    @After("@annotation(targetDataSource)")
    public void clearDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        log.debug("清除数据源 " + targetDataSource.name() + " !");
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}
