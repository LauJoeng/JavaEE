package com.yang.ajaxtest.dao;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.nio.DoubleBuffer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
    private static final QueryRunner runner = new QueryRunner();

    public <T>List<T> getForList(String sql,Class<T>clazz,Object ... args){
        List<T> list = null;

        Connection conn = null;
        try {
            conn = DBManager.getInstance().getConnection();
            list = runner.query(conn,sql,new BeanListHandler<T>(clazz),args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DbUtils.closeQuietly(conn);
        }
        return list;
    }

    public <T> T get(String sql,Class<T>clazz,Object ... args){
        T result = null;
        Connection conn = null;

        conn = DBManager.getInstance().getConnection();
        try {
            result = runner.query(conn,sql,new BeanHandler<T>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(conn);
        }
        return result;
    }
}
