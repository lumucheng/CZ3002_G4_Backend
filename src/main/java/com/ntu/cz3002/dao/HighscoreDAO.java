/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntu.cz3002.dao;

import com.ntu.cz3002.entity.Highscore;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Mucheng
 */
public class HighscoreDAO {
    
    public ArrayList<Highscore> getHighscore(int count, Boolean isSocial) {
        ArrayList<Highscore> highscoreList = new ArrayList<Highscore>();

        Connection conn = null;
        Statement stmt = null;
        int social = (isSocial) ? 1 : 0;

        try {
            Class.forName(DaoUtil.JDBC_DRIVER);
            conn = DriverManager.getConnection(DaoUtil.DB_URL);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM TBL_HIGHSCORE"
                    + " WHERE is_social = " + social
                    + " ORDER BY score LIMIT " + count + ";";
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Highscore highscore = new Highscore();
                highscore.setName(resultSet.getString("name"));
                highscore.setScore(resultSet.getInt("score"));
               
                Boolean is_social = (resultSet.getInt("is_social") > 0) ? true : false;
                highscore.setIs_social(is_social);
                highscore.setLast_update(resultSet.getDate("last_update"));
                highscoreList.add(highscore);
            }

            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return highscoreList;
    }
    
    public String insertHighscore(Highscore highscore) {
        Connection conn = null;
        PreparedStatement pStmt;
        String message = "";

        try {
            Class.forName(DaoUtil.JDBC_DRIVER);
            conn = DriverManager.getConnection(DaoUtil.DB_URL);

            String sql = "INSERT INTO TBL_HIGHSCORE (name, score, is_social, last_update)"
                    + " VALUES (?, ?, ?, ?);";

            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, highscore.getName());
            pStmt.setInt(2, highscore.getScore());
            pStmt.setBoolean(3, highscore.getIs_social());
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            pStmt.setString(4, dateFormat.format(date));

            int rowsAffected = pStmt.executeUpdate();

            if (rowsAffected > 0) {
                message = "Highscore added successfully.";
            } else {
                message = "Something went wrong..";
            }

        } catch (Exception ex) {
            message = ex.getMessage();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return message;
    }
    
}
