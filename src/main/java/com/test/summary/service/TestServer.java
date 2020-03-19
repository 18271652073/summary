package com.test.summary.service;

import com.test.summary.common.component.ConfigValueComponent;
import com.test.summary.common.component.RedisClient;
import com.test.summary.dom.mysql.entity.OrderBase;
import com.test.summary.dom.mysql.mapper.OrderBaseMapper;
import com.test.summary.dom.sqlserver.entity.ItemSku;
import com.test.summary.dom.sqlserver.mapper.ItemSkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Administrator
 * @date 2020/3/16.
 */
@Service
public class TestServer {

    @Autowired
//    @Qualifier("sqlSessionTemplateMysql")
    private OrderBaseMapper orderBaseMapper;
    @Autowired
    private ItemSkuMapper itemSkuMapper;
    @Autowired
    private ConfigValueComponent configValueComponent;
    @Autowired
    private RedisClient redisClient;

    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManagerMySql")
//    , isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED
    public String getMysql() {
        OrderBase orderBase = orderBaseMapper.selectByPrimaryKey(2);
        orderBase.setCustomerName("test1");
//        configValueComponent.ss();
        orderBaseMapper.updateByPrimaryKey(orderBase);
        int a = 1 / 0;
        return orderBase.toString();
    }

    public String getSqlServer() {
        redisClient.set("测试","测试",6000l);
        redisClient.set("test","test",6000l);
        ItemSku itemSku = itemSkuMapper.selectByPrimaryKey("100000000PCS");
        return itemSku.toString();
    }

}
