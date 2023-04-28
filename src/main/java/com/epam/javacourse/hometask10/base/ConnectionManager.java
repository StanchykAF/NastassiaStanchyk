package com.epam.javacourse.hometask10.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost/my_database?" +
                    "user=admin&password=admin";
    private static Connection conn;

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver is not found");
        }
        System.out.println("Driver is registered");
    }

    private static Connection create() {
        registerDriver();
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            System.out.println("Connection is established");
        } catch (SQLException e) {
            System.err.println("Connection is not established");
        }
        return conn;
    }

    public static Connection getConnection() {
        if (conn == null) {
            return create();
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                System.err.println("Error while closing the connection");
            }
        }
    }
}
