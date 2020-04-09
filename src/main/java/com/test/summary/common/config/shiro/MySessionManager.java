package com.test.summary.common.config.shiro;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/11. 自定义sessionId获取
 */
@Component
public class MySessionManager extends DefaultWebSessionManager {


    private static final String AUTHORIZATION = "Authorization";

    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    public MySessionManager() {
        super();
        setGlobalSessionTimeout(DEFAULT_GLOBAL_SESSION_TIMEOUT );
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        HttpServletRequest req = (HttpServletRequest) request;
        //如果请求头中有 Authorization 则其值为sessionId
        String token=req.getParameter("token");
        if (!StringUtils.isEmpty(id)) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        } else if (token!= null) {
            return token;
        } else {
            //否则按默认规则从cookie取sessionId
            Serializable sessionId = super.getSessionId(request, response);
            return sessionId;
        }
    }
}
