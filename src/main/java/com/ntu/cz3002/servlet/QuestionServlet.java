/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntu.cz3002.servlet;

import com.ntu.cz3002.dao.QuestionDAO;
import com.ntu.cz3002.entity.Question;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/questionServlet")
@MultipartConfig(maxFileSize = 16177215)    // 16MB
public class QuestionServlet extends HttpServlet {

    private static final String SAVE_DIR = "/etc/images";

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // creates the save directory if it does not exists
        File dir = new File(SAVE_DIR);
        if (!dir.exists()) {
            dir.mkdir();
        }

        // POST values from insertqns.jsp
        String answer = request.getParameter("answer");
        String tag = request.getParameter("tag");
        Part imagePart = request.getPart("image");
        
        String filePath = "";
        String fileName = "";
        String message = "";

        if (imagePart != null) {
            Date date = new Date();
            int charIndex = imagePart.getSubmittedFileName().indexOf(".");
            String fileExtension = imagePart.getSubmittedFileName()
                    .substring(charIndex);
            fileName = date.getTime() + fileExtension;
            filePath = SAVE_DIR + File.separator + fileName;
            imagePart.write(filePath);

            Question question = new Question();
            question.setAnswer(answer);
            question.setTag(tag);
            question.setImage_path(filePath);
            question.setImage_name(fileName);

            QuestionDAO questionDao = new QuestionDAO();
            message = questionDao.insertQuestion(question);
        } 
        else {
            message = "Error reading uploaded file";
        }
        
        request.setAttribute("Message", message);
        getServletContext().getRequestDispatcher("/response.jsp").forward(request, response);
    }
}
