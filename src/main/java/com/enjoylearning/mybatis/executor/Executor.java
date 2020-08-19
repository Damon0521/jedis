package com.enjoylearning.mybatis.executor;


import com.enjoylearning.mybatis.config.MappedStatement;

import java.util.List;

/**
 * @program: mybatismyself_simple
 * @description:
 * @author: damon
 * @create: 2020-08-15 19:10
 **/


/* 核心接口之一，定义数据库最基础的方法*/
public interface Executor {

    /*查询接口 ，封装mappedStatmentd 对象*/
    <E> List<E> query(MappedStatement ms, Object parameter);

}
