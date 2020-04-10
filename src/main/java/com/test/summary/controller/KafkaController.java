package com.test.summary.controller;

import com.test.summary.common.component.kafka.KafkaSender;
import com.test.summary.common.component.validation.EnumValue;
import com.test.summary.common.constants.ResultEntity;
import com.test.summary.dom.kafka.TopicsConstants;
import com.test.summary.service.TestServer;
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
 * @date 2020/4/10.
 */
@Slf4j
@RestController
@RequestMapping(value = "/kafka")
@Validated
public class KafkaController {

    @Autowired
    private KafkaSender kafkaSender;
    @Autowired
    private TestServer testServer;

    @ApiOperation(value = "send", notes = "send")
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public ResultEntity send(@ApiParam("名称") @NotEmpty(message = "名称非空！") @RequestParam(required = false) String userName,
                             @ApiParam("详细消息") @NotEmpty(message = "消息非空！") @RequestParam(required = false) String msg) {
        kafkaSender.send(TopicsConstants.TOPICS_TEST, userName + "：1" + msg);
        kafkaSender.send(TopicsConstants.TOPICS_TEST1, userName + "：2" + msg);
        kafkaSender.send(TopicsConstants.TOPICS_TEST2, userName + "：3" + msg);
        return ResultEntity.ok("发送成功！");
    }

    @ApiOperation(value = "testThread", notes = "testThread")
    @RequestMapping(value = "/testThread", method = RequestMethod.GET)
    public ResultEntity testThread(@ApiParam("名称") @NotEmpty(message = "名称非空！") @RequestParam(required = false) String userName,
                                   @ApiParam("详细消息") @NotEmpty(message = "消息非空！") @RequestParam(required = false) String msg) throws InterruptedException {
        System.out.println("+++++++++++++testThread begin");
        testServer.testThread(userName, msg);
        System.out.println("+++++++++++++testThread end");
        return ResultEntity.ok("testThread成功！");
    }


}
