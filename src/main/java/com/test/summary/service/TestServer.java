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
import com.test.summary.common.utils.ExcelUtilHelp;
import com.test.summary.common.utils.TurnFile;
import com.test.summary.dom.mysql.entity.OrderBase;
import com.test.summary.dom.mysql.mapper.OrderBaseMapper;
import com.test.summary.dom.sqlserver.entity.ItemSku;
import com.test.summary.dom.sqlserver.mapper.ItemSkuMapper;
import com.test.summary.dom.sqlserver.repository.SysConfigRepository;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

    @Transactional
    public ResultEntity importExcel(MultipartFile file) throws IOException {
        //将文件按时间戳存起来 开始，也可以用uuid去掉-
        String time = String.valueOf(System.currentTimeMillis());
        TurnFile.multipartFileToFile(file, time);
        //将文件按时间戳存起来 结束
        if (file != null) {//将文件转化成list
            InputStream ins = file.getInputStream();
            File toFile = new File(file.getOriginalFilename());
            ExcelUtilHelp.inputStreamToFile(ins, toFile);
            ins.close();
            List<Map> listMap = ExcelUtilHelp.readXlsxByStream(new FileInputStream(toFile));
            for (Map map : listMap) {//遍历excel文件数据
                String name = map.get("名字").toString();
            }
        }
        return ResultEntity.error("1");
    }

    @Async("executor")
    public void testThread(String userName, String msg) throws InterruptedException {
        System.out.println("------------testThread begin");
        Thread.sleep(10000l);
        System.out.println("------------testThread end");
    }
}