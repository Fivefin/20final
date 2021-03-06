package com.example.welcome1.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactoryConfig  {

    private DruidDataSource dataSource;

    private  static ConnectionFactoryConfig connectionFactoryConfig;

    private Connection getConnection() throws SQLException {
        System.err.println("实例化");
        Properties properties = new Properties();
        // 这里需要自己进行加密
        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/welcome1?serverTimezone=GMT%2B8";
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        properties.put("driverClassName",driverClassName);
        properties.put("url",url);
        properties.put("username",user);
        properties.put("password",password);

        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            try {
                init();
            } catch (Exception e2) {
            }
        }
        return  dataSource.getConnection();
    }

    public static Connection getDatabaseConnection() throws SQLException {
        if(connectionFactoryConfig==null){
            connectionFactoryConfig = new ConnectionFactoryConfig();
        }
        return connectionFactoryConfig.getConnection();

    }

    public void init(){
        try {
            if (dataSource != null)
                dataSource.close();
        } catch (Exception e) {
        }
    }
}