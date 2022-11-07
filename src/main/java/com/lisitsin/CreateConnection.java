package com.lisitsin;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class CreateConnection {
    private static Properties properties;
    private static String url;
    private static String username;
    private static String password;

    private CreateConnection instance = new CreateConnection();
    private static String propertyPath ="src/main/resources/rep/mysql.properties";
    @SneakyThrows
    private CreateConnection(){
    }
    @SneakyThrows
    public static Connection getConnection(){
        properties = new Properties();
        Class.forName("com.mysql.jdbc.Driver");
        properties.load(new FileReader(propertyPath));
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }

}
