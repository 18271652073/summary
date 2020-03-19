package com.test.summary.dom.sqlserver.mapper;

import com.test.summary.dom.sqlserver.entity.ItemSku;
import org.springframework.beans.factory.annotation.Qualifier;

//@Qualifier("sqlSessionTemplateSqlServer")
public interface ItemSkuMapper {
    int deleteByPrimaryKey(String itemSkuId);

    int insert(ItemSku record);

    int insertSelective(ItemSku record);

    ItemSku selectByPrimaryKey(String itemSkuId);

    int updateByPrimaryKeySelective(ItemSku record);

    int updateByPrimaryKey(ItemSku record);
}