package com.test.summary.common.component.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2018/9/20.
 */
@Component
public class EmailComponent {
    @Autowired
    private JavaMailSender jms;
    @Value("${spring.mail.username}")
    private String emailFrom;
    @Value("${email.to1}")
    private String emailTo1;
    @Value("${email.to2}")
    private String emailTo2;

    public void sendMail(String subject,String text,String[] toArray) {
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom(emailFrom);
        //接收者
        mainMessage.setTo(toArray);
        //发送的标题
        mainMessage.setSubject(subject);
        //发送的内容
        mainMessage.setText(text);
        jms.send(mainMessage);
    }
}
