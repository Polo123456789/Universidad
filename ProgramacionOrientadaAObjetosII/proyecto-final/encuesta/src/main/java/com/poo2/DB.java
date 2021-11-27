package com.poo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DB {
    private static DB instance = null;
    private Connection conn = null;

    public static final String dbName = "db.sqlite3";
    public static final String connectionStringPrefix = "jdbc:sqlite:";

    public static boolean sqlite3JDBCDriverExists() {
        try {
            Class.forName("org.sqlite.JDBC");
            return true;
        } catch (final ClassNotFoundException e) {
            return false;
        }
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public void connect(String db) throws SQLException {
        conn = DriverManager.getConnection(connectionStringPrefix + db);
        System.out.println("Connection to " + db + " successful");
    }

    public void connect() throws SQLException {
        connect(dbName);
    }

    public void disconnect() throws SQLException {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Closed connection to db");
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }
    
    public Statement execQuery(String query) throws SQLException {
        Statement s = conn.createStatement();
        s.execute(query);
        return s;
    }
}
