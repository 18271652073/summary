package com.test.summary.common.config.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Administrator
 * @date 2020/3/19.
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    /**
     * 实例化拦截器
     * 由于可能会在AdminInterceptor中注入bean所以需要在此实例化，
     * 下面的addInterceptors时候不用new直接调用当前方法
     * 或者不用当前方法，通过SpringContextUtils帮助类
     *
     * @return
     */
    @Bean
    public AdminInterceptor adminInterceptor() {
        return new AdminInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径

        //registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**").excludePathPatterns("/loginPage", "/login");
        InterceptorRegistration registration = registry.addInterceptor(adminInterceptor());
        registration.addPathPatterns("/**");                      //所有路径都被拦截
        registration.excludePathPatterns(
                //添加不拦截路径 从controller起始的路径，不加server.servlet.context-path
                //被添加的路径直接通过，部进入拦截操作。所以这些方法无法通过拦截器加日志。
                "你的登陆路径",            //登录
                "/test/login",           //测试登录
                "/**/*.html",            //html静态资源
                "/**/*.js",              //js静态资源
                "/**/*.css",             //css静态资源
                "/**/*.woff",
                "/**/*.ttf"
        );
    }

}

