package com.test.summary.controller.common;

import com.test.summary.common.component.validation.EnumValue;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


/**
 * @author Administrator
 * @date 2020/3/19.
 */
@Slf4j
@Controller
@RequestMapping(value = "/common")
@Validated
public class CommonController {

    @ResponseBody
    @ApiOperation(value = "login", notes = "login")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ApiParam("账号") @EnumValue(strValues = {"1", "2", "4"}, message = "需要填写指定值！") @RequestParam(required = false, defaultValue = "") String accountNumber,
                        @ApiParam("id") @NotEmpty(message = "id！") @Min(1)  @RequestParam(required = false, defaultValue = "") String id) {
        return accountNumber;
    }

}
