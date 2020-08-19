package com.enjoylearning.mybatis.executor;

import com.enjoylearning.mybatis.config.Configuration;
import com.enjoylearning.mybatis.config.MappedStatement;
import com.sun.deploy.util.ReflectionUtil;
import sun.reflect.Reflection;
import sun.swing.plaf.windows.ClassicSortArrowIcon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatismyself_simple
 * @description:
 * @author: damon
 * @create: 2020-08-15 19:14
 **/
public class DefaultExecutor implements Executor {

    private final Configuration config;

    public DefaultExecutor(Configuration configuration) {
        super();
        this.config = configuration;
    }


    /**
     * 查询接口
     */


    @Override
    public <E> List<E> query(MappedStatement ms, Object parameter) {

        List<E> ret = new ArrayList<E>();
        try {
            Class.forName(config.getJdbcDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(config.getJdbcUrl(), config.getJdbcUserName(), config.getJdbcPassword());
            preparedStatement = connection.prepareStatement(ms.getSql());

            //parameterize

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }


    /**
     * 处理占位符能力,对占位符处理
     */
    private void parmeterize(PreparedStatement preparedStatement, Object paramter) {

        try {
            if (paramter instanceof Integer) {
                preparedStatement.setInt(1, (int) paramter);
            } else if (paramter instanceof Long) {
                preparedStatement.setLong(1, (long) paramter);
            } else if (paramter instanceof String) {
                preparedStatement.setString(1, (String) paramter);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //读取resultSet 中的数据，并且转化目标
    private <E> void handlerResultSet(ResultSet resultSet, List<E> ret, String className) throws SQLException {


        Class<E>  clazz=null;


        try {
            clazz = (Class<E>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        while (resultSet.next()){

            /*通过反射实例化对象*/
            Object entity= clazz.newInstance();
            ReflectionUtil.setPropToBeanFromResultSet

        }






    }


}
