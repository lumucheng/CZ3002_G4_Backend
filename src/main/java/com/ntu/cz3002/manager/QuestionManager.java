/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntu.cz3002.manager;

import com.ntu.cz3002.dao.QuestionDAO;
import com.ntu.cz3002.entity.Question;
import java.util.ArrayList;

/**
 *
 * @author Mucheng
 */
public class QuestionManager {
    
    private QuestionDAO questionDAO;
    private final static String IMG_PATH = "http://52.76.1.45:8080/cz3002/image/";
    
    public QuestionManager() {
        questionDAO = new QuestionDAO();
    }
    
    public ArrayList<Question> getRandomQuestions(int count) {
        
        ArrayList<Question> questionList = questionDAO.getRandomQuestions(count);
        
        for (Question question : questionList) {
            
            question.setImage_url(IMG_PATH + question.getImage_name());
            
            ArrayList<String> wrongAnswers = questionDAO.getRandomWrongAnswers(
                    question.getId(), question.getTag());
            question.setWrong_answers(wrongAnswers);
        }
        
        return questionList;
    }
}
