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
import com.test.summary.common.utils.SpringContextUtils;
import com.test.summary.common.utils.TurnFile;
import com.test.summary.dom.mysql.entity.OrderBase;
import com.test.summary.dom.mysql.mapper.OrderBaseMapper;
import com.test.summary.dom.sqlserver.entity.ItemSku;
import com.test.summary.dom.sqlserver.mapper.ItemSkuMapper;
import com.test.summary.dom.sqlserver.repository.SysConfigRepository;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
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

    private static Integer BASE = 0;
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
    @Autowired
    private AsyncService asyncService;


    //@Transactional(rollbackFor = Exception.class, transactionManager = "transactionManagerMySql")
//    , isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED
    //@ApplyAnnotation
    @Async("executor")
    @TargetDataSource(name = "ds1")//使用后生效了，但是结果无法传到，是由于使用@ApplyAnnotation的缘故
    @Transactional
    //当此处有事务时后面的都会生效（猜想：由于先异步再声明数据源和事务。如过没有数据源则事务不生效），当调用另一个service就失效。需要SpringContextUtils重新生成调用另一个带事务的方法才生效
    public ResultEntity updateSqlServer() throws InterruptedException {
//        AsyncService asyncService = SpringContextUtils.getContext().getBean(AsyncService.class);
        OrderBase orderBase = orderBaseMapper.selectByPrimaryKey(2);
        orderBase.setCustomerName("test4");
//        configValueComponent.ss();
        orderBaseMapper.updateByPrimaryKey(orderBase);
        asyncService.testThread("3", "3");
        //int a = 1 / 0;
        return ResultEntity.ok().setResult(orderBase.toString());
    }

    @TargetDataSource(name = "ds1")
    public ResultEntity updateSqlServer1() {
        OrderBase orderBase = orderBaseMapper.selectByPrimaryKey(2);
        orderBase.setCustomerName("test5");
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

    public void testThread1(String userName, String msg) throws InterruptedException {
        this.BASE = 500;
        //创建一个 Thread 的子类对象
        new Thread(  //把这里面的东西作为 Thread 的构造参数传入进去
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 500; i++) {
                            System.out.println("子线程在执行...." + i);
                            System.out.println((BASE--));//操作的是同一个BASE，展示的可能有点慢
                        }
                    }
                }
        ).start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程在执行...." + i);
            System.out.println((BASE--));
        }
        System.out.println("------------testThread begin");
        Thread.sleep(10000l);
        System.out.println("------------testThread end");
    }
}