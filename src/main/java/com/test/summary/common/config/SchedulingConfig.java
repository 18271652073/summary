package com.test.summary.common.config;

import com.test.summary.common.component.email.EmailComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Slf4j
@Configuration
@EnableScheduling
public class SchedulingConfig {

    @Autowired
    private EmailComponent emailComponent;
    @Value("${email.to1}")
    private String emailTo1;
    @Value("${email.to2}")
    private String emailTo2;
    @Value("${email.to3}")
    private String emailTo3;
    @Value("${email.to4}")
    private String emailTo4;
    @Value("${email.to5}")
    private String emailTo5;
    @Value("${email.to6}")
    private String emailTo6;
    @Value("${email.to7}")
    private String emailTo7;
    @Value("${email.to8}")
    private String emailTo8;

    @Bean
    public TaskScheduler scheduledExecutorService() {//或者log4j.logger.org.springframework.scheduling=INFO
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(8);
        scheduler.setThreadNamePrefix("scheduled-thread-");
        return scheduler;
    }

    /**
     * 定时同步git提交代码行数
     */
    @Scheduled(cron = "${jobs.cron.synGitStatistics}")
    public void synGitStatistics() {
        String msg;
        String[] to = new String[1];
        to[0] = emailTo4;
        try {
            msg = "test";
//            emailComponent.sendMail("发票统计表同步", msg, to);
        } catch (Exception e) {
            log.error("msg：" + e);
            msg = "此次git文件读取失败！";
            emailComponent.sendMail("发票统计表同步", msg, to);
        }
    }


}
