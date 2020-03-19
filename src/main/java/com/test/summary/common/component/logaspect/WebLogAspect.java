package com.test.summary.common.component.logaspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author Administrator
 * @date 2019/3/27.
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    /*
     * 定义一个切入点
     */
    @Pointcut("@annotation(com.test.summary.common.component.logaspect.ApplyAnnotation)")
    public void applyAnnotation() {
    }

    //    @Pointcut("execution(public * com.test.summary.controller..*.*(..))")
    @Pointcut("execution(public * com.test.summary.controller.common..*.*(..))")
    public void webLog() {

    }

    @Before("webLog() || applyAnnotation()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        Enumeration<String> enu = request.getParameterNames();
        String param = "";
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            String value = request.getParameter(name);
            if (value.equals("")) {
                value = "\"\"";
            }
            param += name + "=" + value + ",";
        }
        log.info("URL:" + request.getRequestURL().toString() + "  " + "HTTP_METHOD:" + request.getMethod() + "  " + "IP:" + request.getRemoteAddr() + "  " + "params:{" + param + "}");
    }

    @Around("webLog() || applyAnnotation()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("==================方法环绕前置start=====================>");
        long begin = System.nanoTime();
        //这句必须有 往下执行方法
        Object result = pjp.proceed();
        long end = System.nanoTime();
        log.info("==================方法环绕后置start=====================>");
        log.info("调用Service方法：{}，参数：{}，执行耗时：{}纳秒，耗时：{}毫秒",
                pjp.getSignature().toString(), Arrays.toString(pjp.getArgs()), (end - begin), (end - begin) / 1000000);
        log.info("返回数据：{}", result);
        log.info("==================方法环绕end======================>");
        return result;
    }

//    @AfterReturning(returning = "ResultEntity", pointcut = "webLog()")
//    public void doAfterReturning(Object ResultEntity) throws Throwable {
//        // 处理完请求，返回内容
//        log.info("result:" + ResultEntity.toString());
//    }
//
//
//    /**
//     * 后置异常通知
//     * 定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
//     * throwing:限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
//     * 对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
//     *
//     * @param joinPoint
//     * @param exception
//     */
//    @AfterThrowing(value = "webLog()", throwing = "exception")
//    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
//        log.info("发生了异常!!!!!");
//        log.info(joinPoint.getSignature().getName());
//        if (exception instanceof NullPointerException) {
//            log.info("发生了空指针异常!!!!!");
//        }
//    }

}