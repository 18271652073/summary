package com.test.summary.common.config.shiro;

import com.test.summary.common.component.RedisClient;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Administrator
 * @date 2018/9/5.
 */

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private static final Logger logger = LoggerFactory.getLogger(RetryLimitHashedCredentialsMatcher.class);
    @Autowired
    private RedisClient redisClient;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String) token.getPrincipal();
        Integer count = (int) (redisClient.get(username) == null ? 0 : redisClient.get(username));
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            //clear retry data
            redisClient.remove(username);
        } else {
            count=count + 1;
            if (count > 2) {
                redisClient.set(username, count, (long) 1800);
                logger.warn("username: " + username + " tried to login more than 2times in period");
                throw new ExcessiveAttemptsException("username: " + username + "登录失败超过三次了哦！锁定半小时！");
            }
            redisClient.set(username, count, (long) 1800);
//            System.out.println("登录失败次数！" + count);
        }
        return matches;
    }
}
