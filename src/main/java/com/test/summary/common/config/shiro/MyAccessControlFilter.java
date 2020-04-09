//package com.test.summary.common.config.shiro;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.filter.AccessControlFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletResponse;
//import java.io.PrintWriter;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Administrator
// * @date 2018/8/31.
// */
//public class MyAccessControlFilter extends AccessControlFilter {
//
//    @Autowired
//    private LoginInfoMapper loginInfoMapper;
//
//    static final String LOGIN_URL = "login.html";
//    static final String NEW_PASSWORD_URL = "404.html";
//    static String msg = "";
//    static String code = "";
//
//    //    isAccessAllowed：即是否允许访问，返回true表示允许；
//    //    onAccessDenied：表示访问拒绝时是否自己处理，
//    //    如果返回true表示自己不处理且继续拦截器链执行，返回false表示自己已经处理了（比如重定向到另一个页面）。
//    @Override
//    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
//        System.out.println("AccessControlFilter:isAccessAllowed拦截执行");
//        String uri = getPathWithinApplication(servletRequest);
//        System.out.println("用户正在访问：" + uri);
//        Map<String, Object> appliedPaths = this.appliedPaths;
//        if (appliedPaths.get(uri) == null) {
//            this.msg = "未授权！";
//            this.code = "702";
//            return false;
//        }
//        String[] powerList= (String[]) appliedPaths.get(uri);
//        Subject subject = getSubject(servletRequest, servletResponse);
//        if (SecurityUtils.getSubject().getPrincipal() == null) {
//            this.msg = "登录超时！请重新登录！";
//            this.code = "10010";
//            return false;
//        } else {
//            LoginInfo loginInfo = (LoginInfo) subject.getPrincipal();
//            if(Arrays.asList(powerList).contains(loginInfo.getAccountType())){
//                return true;
//            }
//            this.msg = "未授权！";
//            this.code = "702";
//            return false;
//        }
//    }
//
//    @Override
//    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
//        //ajax時使用下面的
//        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        res.setHeader("Access-Control-Allow-Origin", "*");
//        res.setStatus(HttpServletResponse.SC_OK);
//        res.setHeader("content-type", "text/html;charset=UTF-8");
//        res.setCharacterEncoding("UTF-8");
//        PrintWriter writer = res.getWriter();
//        Map<String, Object> map = new HashMap<>();
//        map.put("resultCode", code);
//        map.put("resultMessage", msg);
//        map.put("success", true);
//        writer.write(JSON.toJSONString(map));
//        writer.close();
//        return false;
//    }
//}
