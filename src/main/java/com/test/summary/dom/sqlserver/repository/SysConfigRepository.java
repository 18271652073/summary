package com.test.summary.dom.sqlserver.repository;

import com.test.summary.dom.sqlserver.entity.ItemSku;
import com.test.summary.dom.sqlserver.mapper.ItemSkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @date 2020/3/19.
 */
@Repository
public class SysConfigRepository {

    @Autowired
    private ItemSkuMapper itemSkuMapper;

    /**
     * 查询加密的key
     *
     * @param configName
     * @return
     */
    @Cacheable(value = "UserInfoList", keyGenerator = "simpleKeyGenerator")
    // 根据value去RedisConfig找设置的对应时间：3000秒，没有就使用默认
    //@Cacheable(value = "SysConfig", key = "'sysConfig'+#configName+#configClass", condition = "#configName.length()>2")
    public ItemSku getDes3Key(String configName, String configClass) {
        ItemSku itemSku = itemSkuMapper.selectByPrimaryKey(configClass);
        return itemSku;
    }
}