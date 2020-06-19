package com.test.summary.controller;

import com.test.summary.common.component.RedisClient;
import com.test.summary.common.component.idempotent.Idempotent;
import com.test.summary.common.component.limit.Limit;
import com.test.summary.common.component.limit.LimitType;
import com.test.summary.common.component.logaspect.ApplyAnnotation;
import com.test.summary.common.config.exception.BaseException;
import com.test.summary.common.constants.ResultEntity;
import com.test.summary.controller.common.BaseController;
import com.test.summary.service.TestServer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/3/16.
 */
@Slf4j
@Controller
@RequestMapping(value = "/test")
public class TestController extends BaseController {

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
    public ResultEntity getMysql() throws InterruptedException {
        System.out.println("+++++++++++++testThread begin");
        ResultEntity resultEntity = testServer.updateSqlServer();
        System.out.println("+++++++++++++testThread end");
        return ResultEntity.ok("1111");
//        return resultEntity;
    }

    @ResponseBody
    @ApiOperation(value = "getMysql1", notes = "getMysql1")
    @RequestMapping(value = "/getMysql1", method = RequestMethod.POST)
    public ResultEntity getMysql1() throws InterruptedException {
        ResultEntity resultEntity = testServer.updateSqlServer1();
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

    @ResponseBody
    @ApiOperation(value = "idempotentTest", notes = "idempotentTest")
    @RequestMapping(value = "/idempotentTest", method = RequestMethod.POST)
    //@Idempotent(expirMillis = 1000)
    //100秒内只能访问10次，limitType=IP时根据ip限流，等于CUSTOMER根据key限流，默认根据小写的方法名
    @Limit(key = "test", period = 100, count = 10, name="resource", prefix = "limit")
    public ResultEntity idempotentTest(@ApiParam("12") @RequestParam List<String> ids,
                                       @ApiParam("1212") @RequestParam List<String> id) {
        System.out.println(ids);
        System.out.println(id);
        return ResultEntity.ok().setResult("123123");
    }

    @ApiOperation(value = "选中导出", notes = "选中导出")
    @RequestMapping(value = "/selectExportOrderInfo", method = RequestMethod.GET)
    //@CrossOrigin
    public void selectExportOrderInfo(HttpServletResponse response,
                                      @ApiParam("客户号码") @RequestParam List<String> ids) throws Exception {
        Workbook workbook = testServer.selectExportOrderInfo(ids);
        if (null != workbook) {
            prepareDownLoadResponse(response, "application/x-xls", "订单信息.xlsx");
            ByteArrayOutputStream ostream = null;
            ServletOutputStream stream = null;
            try {
                ostream = new ByteArrayOutputStream();
                workbook.write(ostream);
                stream = response.getOutputStream();
                stream.write(ostream.toByteArray());
                stream.flush();
            } catch (IOException e) {
                log.error("条件查询订单信息后导出出错", e);
                throw new BaseException("条件查询订单信息后导出出错");
            } finally {
                stream.close();
                ostream.close();
            }
        }
    }

}
