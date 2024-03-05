package com.example.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DBHandler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort +"/" +dbName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public void RegUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE +
                "(" + Const.USERS_NAME + "," + Const.USERS_EMAIL +
                "," + Const.USERS_GROUP + "," + Const.USERS_PASSWORD + ")"
                + "VALUES(?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getEmail());
            prSt.setString(3, user.getGroup());
            prSt.setString(4, user.getPassword());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_NAME + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
