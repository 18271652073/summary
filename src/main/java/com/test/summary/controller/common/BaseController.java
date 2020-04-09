package com.test.summary.controller.common;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author
 * @date 2018/7/17.
 */
public class BaseController {

    protected void prepareDownLoadResponse(HttpServletResponse response, String contentType, String fileName) {
        String name = null;
        try {
            name = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Content-disposition", "attachment; filename=\"" + name + "\"");
        response.setContentType(contentType);
    }
}
