/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntu.cz3002.servlet;

import com.ntu.cz3002.dao.QuestionDAO;
import com.ntu.cz3002.entity.Question;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/questionServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class QuestionServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
        String answer = request.getParameter("answer");
        String tag = request.getParameter("tag");
         
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("image");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
        Question question = new Question();
        question.setAnswer(answer);
        question.setTag(tag);
        question.setInputStream(inputStream);
         
        QuestionDAO questionDao = new QuestionDAO();
        String message = questionDao.insertQuestion(question);

        request.setAttribute("Message", message);
        getServletContext().getRequestDispatcher("/response.jsp").forward(request, response);
    }
}
