package com.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    // 数据库驱�?,不需要改�?
    private static String DRIVER;
    // 数据库连接URL
    private static String URL;
    // 数据库连接用户名
    private static String USERNAME;
    // 数据库连接密�?
    private static String PASSWORD;

    public static String fileName = "/app.properties";

    static {
        Properties properties = new Properties();
        // 加载文件�?
        try {
            // 类名.class 说明：JVM将使用类装载�? 将类装入内存
            // 不做类的初始化工作�?�返回Class的对�?
            properties.load(JDBCUtils.class.getResourceAsStream(fileName));
            // 获取配置文件中的属�?��??
            DRIVER = properties.getProperty("STD_DRIVER");
            URL = properties.getProperty("STD_URL");
            USERNAME = properties.getProperty("STD_USERNAME");
            PASSWORD = properties.getProperty("STD_PASSWORD");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 数据库驱动加�?
        // 1. 注册驱动.
        // java类加载机制，加载com.mysql.jdbc.Driver
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("类全�?" + DRIVER + "没有找到");
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
