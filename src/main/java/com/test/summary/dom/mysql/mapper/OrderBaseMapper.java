package com.test.summary.dom.mysql.mapper;

import com.test.summary.dom.mysql.entity.OrderBase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

//@Repository
//@Qualifier("sqlSessionTemplateMysql")
public interface OrderBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderBase record);

    int insertSelective(OrderBase record);

    OrderBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderBase record);

    int updateByPrimaryKey(OrderBase record);
}