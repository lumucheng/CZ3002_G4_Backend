/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntu.cz3002.dao;

import com.ntu.cz3002.entity.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuestionDAO {

    public ArrayList<Question> getRandomQuestions(int count) {
        ArrayList<Question> datasetList = new ArrayList<Question>();

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(DaoUtil.JDBC_DRIVER);
            conn = DriverManager.getConnection(DaoUtil.DB_URL);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM TBL_DATASET ORDER BY RAND() LIMIT "
                    + count + ";";
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Question question = new Question();
                question.setId(resultSet.getInt("id"));
                question.setAnswer(resultSet.getString("answer"));
                question.setTag(resultSet.getString("tag"));
                question.setImage_path(resultSet.getString("image_path"));
                question.setImage_name(resultSet.getString("image_name"));

//                Blob imageBlob = resultSet.getBlob("image");
//                if (imageBlob != null) {
//                    byte[] imageByte = imageBlob.getBytes(1, (int) imageBlob.length());
//                    String image = Base64.encodeBase64String(imageByte);
//                    question.setImage(image);
//                }
                datasetList.add(question);
            }

            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return datasetList;
    }

    public ArrayList<String> getRandomWrongAnswers(int questionId, String tag) {
        ArrayList<String> wrongAnswers = new ArrayList<String>();

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(DaoUtil.JDBC_DRIVER);
            conn = DriverManager.getConnection(DaoUtil.DB_URL);
            stmt = conn.createStatement();
            String sql = "SELECT answer FROM TBL_DATASET WHERE "
                    + "id <> " + questionId
                    + " AND tag = '" + tag + "' "
                    + "ORDER BY RAND() LIMIT 3;";
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                String answer = resultSet.getString("answer");
                wrongAnswers.add(answer);
            }

            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return wrongAnswers;
    }

    public String insertQuestion(Question question) {
        Connection conn = null;
        PreparedStatement pStmt;
        String message = "";

        try {
            Class.forName(DaoUtil.JDBC_DRIVER);
            conn = DriverManager.getConnection(DaoUtil.DB_URL);

            String sql = "INSERT INTO TBL_DATASET (image_path, image_name, answer, tag)"
                    + " VALUES (?, ?, ?, ?);";

            pStmt = conn.prepareStatement(sql);
            //pStmt.setBlob(1, question.getInputStream());
            pStmt.setString(1, question.getImage_path());
            pStmt.setString(2, question.getImage_name());
            pStmt.setString(3, question.getAnswer());
            pStmt.setString(4, question.getTag());

            int rowsAffected = pStmt.executeUpdate();

            if (rowsAffected > 0) {
                message = "Question added successfully.";
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
