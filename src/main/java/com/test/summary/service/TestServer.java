package com.test.summary.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.test.summary.common.component.ConfigValueComponent;
import com.test.summary.common.component.RedisClient;
import com.test.summary.common.component.logaspect.ApplyAnnotation;
import com.test.summary.common.config.datasource.TargetDataSource;
import com.test.summary.common.constants.ApiConstant;
import com.test.summary.common.constants.ResultEntity;
import com.test.summary.common.utils.ExcelUtil;
import com.test.summary.dom.mysql.entity.OrderBase;
import com.test.summary.dom.mysql.mapper.OrderBaseMapper;
import com.test.summary.dom.sqlserver.entity.ItemSku;
import com.test.summary.dom.sqlserver.mapper.ItemSkuMapper;
import com.test.summary.dom.sqlserver.repository.SysConfigRepository;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private SysConfigRepository sysConfigRepository;


    //@Transactional(rollbackFor = Exception.class, transactionManager = "transactionManagerMySql")
//    , isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED
    //@ApplyAnnotation
    @TargetDataSource(name = "ds1")//使用后生效了，但是结果无法传到，是由于使用@ApplyAnnotation的缘故
    @Transactional
    public ResultEntity getMysql() {
        OrderBase orderBase = orderBaseMapper.selectByPrimaryKey(2);
        orderBase.setCustomerName("test3");
//        configValueComponent.ss();
        orderBaseMapper.updateByPrimaryKey(orderBase);
        int a = 1 / 0;
        return ResultEntity.ok().setResult(orderBase.toString());
    }

    @TargetDataSource(name = "ds2")
    public String getSqlServer() {
        redisClient.set("测试", "测试", 6000l);
        redisClient.set("test", "test", 6000l);
//        ItemSku itemSku = itemSkuMapper.selectByPrimaryKey("100000000PCS");
        ItemSku itemSku = sysConfigRepository.getDes3Key("12312", "100000000PCS");
        return itemSku.toString();
    }

    public Workbook selectExportOrderInfo(List<String> ids) {
        TemplateExportParams params = new TemplateExportParams(ExcelUtil.convertTemplatePath(ApiConstant.ORDER_INFO_ERROR));
        Map<String, Object> map = new HashMap();
        Integer curPage = 1;//每页二十万，导出最大为200000;
        Integer pageSize = 200000;
        //List<Map> exportMap = orderBaseMapper.selectExportOrderInfo(ids);
        List<Map> exportMap = null;
        map.put("list", exportMap);
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        return workbook;
    }


}
