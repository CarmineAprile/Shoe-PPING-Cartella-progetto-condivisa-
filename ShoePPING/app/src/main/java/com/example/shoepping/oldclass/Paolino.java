package com.example.shoepping.oldclass;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Paolino {

    private static final String SQL_EXCEPTION = "SQL Error: ";

    private final String ip;
    private final String port;
    private final String db;
    private final String username;
    private final String watchword;

    private String timeout = "500";  // Default timeout

    public Paolino() {
        this.ip = "192.168.151.123";  // Wi-Fi wireless LAN card (Windows: use 'ipconfig' on command prompt)
        this.port = "3306";
        this.db = "prova";
        this.username = "Root";
        this.watchword = "Root";
    }

    /*public DBConnection(String timeout) {
        this.ip = BuildConfig.IP_ADDRESS;
        this.port = BuildConfig.DB_PORT;
        this.db = BuildConfig.DB_NAME;
        this.username = BuildConfig.DB_USERNAME;
        this.watchword = BuildConfig.DB_WATCHWORD;
        this.timeout = timeout;
    }*/

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public String getDb() {
        return db;
    }

    public String getUsername() {
        return username;
    }

    public String getWatchword() {
        return watchword;
    }

    public Connection getConnection() {
        Connection connection = null;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String connectionURL;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connectionURL = "jdbc:mysql://" + this.getIp() + ":" + this.getPort() + "/" + this.getDb() + "?user=" +
                    this.getUsername() + "&password=" + this.getWatchword();
            Properties properties = new Properties();
            properties.put("connectTimeout", timeout);
            connection = DriverManager.getConnection(connectionURL, properties);
        }
        catch (SQLException se) {
            Log.e(SQL_EXCEPTION, se.getMessage());
        }
        catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }

        return connection;
    }

    /*public void closeStatement(com.mysql.jdbc.CallableStatement stmt) {
        try {
            stmt.close();
        }
        catch (SQLException e) {
            Log.e(SQL_EXCEPTION, e.getMessage());
        }
    }*/

    public void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            Log.e(SQL_EXCEPTION, e.getMessage());
        }
    }

}