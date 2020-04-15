package com.test.summary.dom.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 * @date 2020/4/10.
 */
@Data
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Message {

    private String id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳

    public static void main(String[] args) {
        //测试实体转换空字段的值给空
        Message message=new Message();
        message.setMsg("123");
        String str = JSON.toJSONString(message, new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect});
        String str2 = JSON.toJSONString(message.toString());
        System.out.println(str);
        System.out.println(str2);
    }
}

