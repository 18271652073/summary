package com.test.summary.controller;

import com.test.summary.common.constants.ResultEntity;
import com.test.summary.service.EsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

/**
 * @author Administrator
 * @date 2020/4/21.
 */
@Slf4j
@RestController
@RequestMapping(value = "/es")
@Validated
public class EsController {

    @Autowired
    private EsService esService;

    @ApiOperation(value = "getEs", notes = "getEs")
    @RequestMapping(value = "/getEs", method = RequestMethod.GET)
    public ResultEntity getEs(@ApiParam("名称") @NotEmpty(message = "名称非空！") @RequestParam(required = false) String userName,
                                   @ApiParam("详细消息") @NotEmpty(message = "消息非空！") @RequestParam(required = false) String msg) throws InterruptedException {
        //esService.getEs();
        return ResultEntity.ok("testThread成功！");
    }

}
