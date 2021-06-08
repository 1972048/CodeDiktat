package com.javaswingJDBC.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String URL="jdbc:mysql://localhost:3306/schoop1";
    private static final String USERNAME="root";
    private static final String PASSWORD="abcd1234";

    public static Connection createConnection() throws ClassNotFoundException,SQLException  {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        connection.setAutoCommit(false);
        return connection;
    }

}
