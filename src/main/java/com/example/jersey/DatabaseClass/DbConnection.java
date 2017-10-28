package com.example.jersey.DatabaseClass;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public Connection getConnection() throws Exception{
        String connectionURL = "jdbc:mysql://localhost:3306/form";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection connection = DriverManager.getConnection(connectionURL,"root","419244");
        return connection;
    }
}
