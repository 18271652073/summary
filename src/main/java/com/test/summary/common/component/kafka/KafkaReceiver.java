package com.test.summary.common.component.kafka;

import com.test.summary.dom.kafka.Message;
import com.test.summary.dom.kafka.TopicsConstants;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Administrator
 * @date 2020/4/10.
 */
@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {TopicsConstants.TOPICS_TEST, TopicsConstants.TOPICS_TEST1})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object messageObj = kafkaMessage.get();
            JSONObject jsonObject = JSONObject.fromObject(messageObj);
            Message message = (Message) JSONObject.toBean(jsonObject, Message.class);
            // TODO: 2020/4/10 对监听的数据进行处理,根据id或者其他的确定数据
            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message + "id:" + message.getId());
        }

    }
}
