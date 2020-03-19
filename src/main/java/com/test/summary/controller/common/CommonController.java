package com.test.summary.controller.common;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author Administrator
 * @date 2020/3/19.
 */
@Slf4j
@Controller
@RequestMapping(value = "/common")
public class CommonController {

    @ResponseBody
    @ApiOperation(value = "login", notes = "login")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ApiParam("账号") @RequestParam(required = false, defaultValue = "") String accountNumber) {
        return accountNumber;
    }

}
