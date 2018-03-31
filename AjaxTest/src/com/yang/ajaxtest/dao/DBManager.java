package com.yang.ajaxtest.dao;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
    private static DataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource("ajaxApp");
    }

    public Connection getConnection(){
        Connection connection = null;
        if (dataSource!=null){
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private DBManager(){}

    private static DBManager instance = new DBManager();

    public static DBManager getInstance(){
        return instance;
    }
}
