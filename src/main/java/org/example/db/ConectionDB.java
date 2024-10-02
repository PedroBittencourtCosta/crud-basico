package org.example.db;

import java.sql.*;

public class ConectionDB {

    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/crud-basico";
    private static final String username = "postgres";
    private static final String password = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
