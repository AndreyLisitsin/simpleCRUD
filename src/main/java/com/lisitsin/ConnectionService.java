package com.lisitsin;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionService {
    private Properties properties;
    private String url;
    private String username;
    private String password;
    private static String propertyPath ="src/main/resources/application.properties";


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

}
