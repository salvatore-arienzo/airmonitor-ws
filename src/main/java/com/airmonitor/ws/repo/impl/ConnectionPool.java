package com.airmonitor.ws.repo.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://queenie.db.elephantsql.com:5432/rbqltxvt", "rbqltxvt", "9Kz5XWyAoiQzMVPJK-N3dGiVUxI3FFa0");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
