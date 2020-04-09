package com.test.summary.controller;

import com.test.summary.common.component.RedisClient;
import com.test.summary.common.component.logaspect.ApplyAnnotation;
import com.test.summary.common.constants.ResultEntity;
import com.test.summary.service.TestServer;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/3/16.
 */
@Slf4j
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestServer testServer;
    @Autowired
    private RedisClient redisClient;

    @ApiOperation(value = "login", notes = "login")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model) {
        redisClient.set("loginUser", request.getSession().getId());
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        model.addAttribute("name", "登录页面");
        model.addAttribute("strList", list);
        model.addAttribute("show", false);
        return "login";
    }

    @ApiOperation(value = "login1", notes = "login1")
    @RequestMapping(value = "/login1", method = RequestMethod.GET)
    public ModelAndView login1(Model model) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        model.addAttribute("name", "登录页面");
        model.addAttribute("strList", list);
        model.addAttribute("show", false);
        return new ModelAndView("login", "userModel", model);
    }

    @ApiOperation(value = "error", notes = "error")//拦截器controller报错跳到error
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView error(Model model) {
        return new ModelAndView("error");
    }

    @ResponseBody
    @ApiOperation(value = "getMysql", notes = "getMysql")
    @RequestMapping(value = "/getMysql", method = RequestMethod.POST)
    public ResultEntity getMysql() {
        ResultEntity resultEntity = testServer.getMysql();
//        return ResultEntity.ok("1111");
        return resultEntity;
    }

    @ResponseBody
    @ApiOperation(value = "getSqlServer", notes = "getSqlServer")
    @RequestMapping(value = "/getSqlServer", method = RequestMethod.POST)
    //@ApplyAnnotation
    public ResultEntity getSqlServer() {
        System.out.println("2222222222222");
        System.out.println("1111111111111");
        return ResultEntity.ok().setResult(testServer.getSqlServer());
    }

}
