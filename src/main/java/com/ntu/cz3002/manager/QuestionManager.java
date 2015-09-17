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
    private final static int numQuestions = 10;
    
    public QuestionManager() {
        questionDAO = new QuestionDAO();
    }
    
    public ArrayList<Question> getRandomQuestions() {
        
        ArrayList<Question> questionList = questionDAO.getRandomQuestions(numQuestions);
        
        for (Question question : questionList) {
            ArrayList<String> wrongAnswers = 
                    questionDAO.getRandomWrongAnswers(question.getId(), question.getTag());
            question.setWrong_answers(wrongAnswers);
        }
        
        return questionList;
    }
}
