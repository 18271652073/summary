package com.test.summary.controller;

import com.test.summary.common.constants.ResultEntity;
import com.test.summary.service.TestServer;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2020/3/16.
 */
@Slf4j
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestServer testServer;


    @ApiOperation(value = "getMysql", notes = "getMysql")
    @RequestMapping(value = "/getMysql", method = RequestMethod.POST)
    public ResultEntity getMysql() {
        return ResultEntity.ok().setResult(testServer.getMysql());
    }

    @ApiOperation(value = "getSqlServer", notes = "getSqlServer")
    @RequestMapping(value = "/getSqlServer", method = RequestMethod.POST)
    public ResultEntity getSqlServer() {
        return ResultEntity.ok().setResult(testServer.getSqlServer());

    }

}
