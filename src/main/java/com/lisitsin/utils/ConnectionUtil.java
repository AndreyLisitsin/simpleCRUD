package com.lisitsin.utils;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {
    private static Properties properties;
    private static String url;
    private static String username;
    private static String password;

    private static ConnectionUtil instance;
    private static String propertyPath ="src/main/resources/rep/mysql.properties";

    private ConnectionUtil(){}



    @SneakyThrows
    public Connection getConnection(){
        properties = new Properties();
        Class.forName("com.mysql.jdbc.Driver");
        properties.load(new FileReader(propertyPath));
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }

    public static ConnectionUtil GetConnectionUtil(){
        if (instance == null) {
            instance = new ConnectionUtil();
        }
        return instance;
    }

}
