package com.test.summary.common.component.kafka;

import com.alibaba.fastjson.JSON;
import com.test.summary.dom.kafka.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author Administrator
 * @date 2020/4/10.
 * 需要注意不要和configuration-processor包冲突
 */
@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //发送消息方法
    public void send(String topic, String msg) {
        Message message = new Message();
        //message.setId(String.valueOf(System.currentTimeMillis()));
        message.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        message.setMsg(msg);
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", JSON.toJSONString(message));
        kafkaTemplate.send(topic, JSON.toJSONString(message));
    }
}

