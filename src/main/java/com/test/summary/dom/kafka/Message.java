package com.test.summary.dom.kafka;

import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 * @date 2020/4/10.
 */
@Data
public class Message {

    private String id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳

}

