/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntu.cz3002.manager;

import com.ntu.cz3002.dao.HighscoreDAO;
import com.ntu.cz3002.entity.Highscore;
import java.util.ArrayList;

/**
 *
 * @author Mucheng
 */
public class HighscoreManager {
    
    private HighscoreDAO highscoreDAO = null;
    private final static int NUM_HIGHSCORE = 10;
    private final static Boolean SOCIAL_HIGHSCORE = true;
    private final static Boolean DATASET_HIGHSCORE = false;
    
    public HighscoreManager() {
        highscoreDAO = new HighscoreDAO();
    }
    
    public ArrayList<ArrayList<Highscore>> getHighScores() {
        
        ArrayList<ArrayList<Highscore>> highscoreList = 
                new ArrayList<ArrayList<Highscore>>();
        
        ArrayList<Highscore> socialHighScoreList = 
                highscoreDAO.getHighscore(NUM_HIGHSCORE, SOCIAL_HIGHSCORE);
        
        ArrayList<Highscore> datasetHighScoreList = 
                highscoreDAO.getHighscore(NUM_HIGHSCORE, DATASET_HIGHSCORE);
        
        highscoreList.add(socialHighScoreList);
        highscoreList.add(datasetHighScoreList);
        
        return highscoreList;
    }
    
        
    public String insertHighscore(Highscore highscore) {
        return highscoreDAO.insertHighscore(highscore);
    }
}
