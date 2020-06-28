package com.test.summary.service;

import com.test.summary.common.constants.ResultEntity;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @date 2020/6/28.
 */
@Service
public class ThreadService {

    private static Logger logger = LoggerFactory.getLogger(ThreadService.class);

    @Resource(name = "executor")
    private ThreadPoolTaskExecutor taskExecutor;

    public ResultEntity executorThread() {
        //同步辅助类需要通过这个类来控制所有的线程都执行完成;
        List<String> list = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            final int j = i;
            taskExecutor.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "---" + j);
                        String b = testThread(j);
                        list.add(b);
                    } catch (Exception e) {
                        e.printStackTrace();
                        list.add("失败：" + j);
                        //throw e;//抛异常还是会执行
                    } finally {
                        countDownLatch.countDown();  //这个不管是否异常都需要数量减,否则会被堵塞无法结束
                    }
                }
            });
        }
        try {
            countDownLatch.await(); //保证之前的所有的线程都执行完成，才会走下面的；
            // 这样就可以在下面拿到所有线程执行完的集合结果
        } catch (Exception e) {
            logger.error("阻塞异常");
        }
        return ResultEntity.ok().setResult(list);
    }

    public String testThread(int j) {
        int b = 0;
        if (j == 10) {
            System.out.println(j + b);
            b = 12 / 0;
            System.out.println(j + b);
        } else {
            System.out.println(j + b);
        }
        return j + "";
    }

}
