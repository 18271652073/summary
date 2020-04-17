package com.test.summary.service;

import com.test.summary.dom.mysql.entity.OrderBase;
import com.test.summary.dom.mysql.mapper.OrderBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @date 2020/4/17.
 */
@Service
public class AsyncService {

    @Autowired
    private OrderBaseMapper orderBaseMapper;

    //@Async("executor")
    @Transactional
    public void testThread(String userName, String msg) throws InterruptedException {
        System.out.println("------------testThread begin");
        Thread.sleep(10000l);
        OrderBase orderBase = orderBaseMapper.selectByPrimaryKey(Integer.valueOf(userName));
        orderBase.setCustomerName("test4");
//        configValueComponent.ss();
        orderBaseMapper.updateByPrimaryKey(orderBase);
        System.out.println("------------testThread end");
    }

}
