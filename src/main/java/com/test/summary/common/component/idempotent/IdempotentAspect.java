package com.test.summary.common.component.idempotent;

import java.lang.reflect.Method;
import java.util.Objects;

import com.test.summary.common.config.exception.CustomMessageException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCommands;

/**
 * @author Administrator
 * 自定义切点
 * @date 2020/6/16.
 */
@Component
@Aspect
@ConditionalOnClass(RedisTemplate.class)
public class IdempotentAspect {
    private static final String KEY_TEMPLATE = "idempotent_%S";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 切点(自定义注解)
     */
    @Pointcut("@annotation(com.test.summary.common.component.idempotent.Idempotent)")
    public void executeIdempotent() {

    }

    /**
     * 切点业务
     * 不依赖Redis的异步客户端lettuce(pom里去掉)
     * @throws Throwable
     */
    @Around("executeIdempotent()")
    public Object arountd(ProceedingJoinPoint jPoint) throws Throwable {
        //获取当前方法信息
        Method method = ((MethodSignature) jPoint.getSignature()).getMethod();
        //获取注解
        Idempotent idempotent = method.getAnnotation(Idempotent.class);
        //生成Key
        String key = String.format(KEY_TEMPLATE, idempotent.key() + "_" + IdempotentKeyUtil.generate(method, jPoint.getArgs()));
        //https://segmentfault.com/a/1190000002870317 -- JedisCommands接口的分析
        //nxxx的值只能取NX或者XX，如果取NX，则只有当key不存在是才进行set，如果取XX，则只有当key已经存在时才进行set
        //expx expx的值只能取EX或者PX，代表数据过期时间的单位，EX代表秒，PX代表毫秒
        // key value nxxx(set规则) expx(取值规则) time(过期时间)
        String redisRes = redisTemplate.execute((RedisCallback<String>) conn -> ((JedisCommands) conn.getNativeConnection()).set(key, key, "NX", "EX", idempotent.expirMillis()));
        // Jedis jedis = new Jedis("127.0.0.1",6379);
        // jedis.auth("xuzz");
        // jedis.select(0);
        // String redisRes = jedis.set(key, key,"NX","EX",idempotent.expirMillis());
        if (Objects.equals("OK", redisRes)) {
            return jPoint.proceed();
        } else {
            throw new CustomMessageException("sorry!! Interface duplicates requests, violating idempotency.");
//            System.err.println("数据错误");
//            return null;
        }

    }

}
