package com.test.summary.common.config.interceptor;

import com.test.summary.common.component.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * @date 2020/3/19.
 */
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisClient redisClient;

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("执行了TestInterceptor的preHandle方法");
        String getContextPath = request.getContextPath();
        String getRequestURL = request.getRequestURL().toString();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + getContextPath + "/" + getRequestURL;
        System.out.println("用户正在访问：" + getRequestURL);
        try {
            //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
//            User user = (User) request.getSession().getAttribute("USER");
//            if (user != null) {
//                return true;
//            }
            if (redisClient.get("loginUser") != null && request.getSession().getId().equals(redisClient.get("loginUser"))) {
                return true;
            }
            response.sendRedirect(request.getContextPath() + "/test/login");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后，报错不执行，执行下面的afterCompletion）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("执行了TestInterceptor的postHandle方法");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws IOException {
        System.out.println("执行了TestInterceptor的afterCompletion方法");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        //response.getWriter().write("result.toString()");
        //当需要response输出的时候返回值一定要为空,此时返回值是这里的值（result.toString()）,
        //WebLogAspect有response时以WebLogAspect先输出此处拼接在后
    }


}
