package com.test.summary.dom.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @date 2020/4/10.
 */
@Data
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Message implements Serializable {

    private String id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳

    public static void main(String[] args) {
        //测试实体转换空字段的值给空
        Message message = new Message();
        message.setMsg("123");
        message.setSendTime(new Date());
        String str = JSON.toJSONString(message, new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect});
        //WriteMapNullValue  空值默认给null
        //WriteNullStringAsEmpty  如果是字符串类型为空的参数赋值""
        //WriteNullNumberAsZero   空数值默认给0
        //WriteDateUseDateFormat  时间修改格式
        //1.单个关闭 JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
        //2.全局配置关闭 JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";//与WriteDateUseDateFormat搭配使用
        String str1 = JSON.toJSONString(message, new SerializerFeature[]{SerializerFeature.UseISO8601DateFormat, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteDateUseDateFormat});
        String str2 = JSON.toJSONString(message.toString());
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }
}

