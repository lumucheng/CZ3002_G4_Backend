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
    private final static int numHighscore = 10;
    private final static Boolean socialHighscore = true;
    private final static Boolean datasetHighscore = false;
    
    public HighscoreManager() {
        highscoreDAO = new HighscoreDAO();
    }
    
    public ArrayList<Highscore> getHighScores() {
        
        ArrayList<Highscore> highscoreList = new ArrayList<Highscore>();
        
        highscoreList.addAll(highscoreDAO.getHighscore(numHighscore, socialHighscore));
        highscoreList.addAll(highscoreDAO.getHighscore(numHighscore, datasetHighscore));
        
        return highscoreList;
    }
    
        
    public String insertHighscore(Highscore highscore) {
        return highscoreDAO.insertHighscore(highscore);
    }
}
