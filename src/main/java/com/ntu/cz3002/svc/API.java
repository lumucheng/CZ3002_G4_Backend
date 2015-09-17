/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntu.cz3002.svc;

import com.ntu.cz3002.entity.Highscore;
import com.ntu.cz3002.entity.Question;
import com.ntu.cz3002.manager.HighscoreManager;
import com.ntu.cz3002.manager.QuestionManager;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api")
public class API {
    
    QuestionManager questionMgr = new QuestionManager();
    HighscoreManager highscoreMgr = new HighscoreManager();
    
    @GET
    @Path("/getDataset/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Question> getDataSet() {
        return questionMgr.getRandomQuestions();
    }
    
    @GET
    @Path("/getHighscore/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Highscore> getHighscore() {
        return highscoreMgr.getHighScores();
    }
    
    @GET
    @Path("/insertHighscore/name={name}&score={score}&is_social={is_social}")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertHighscore(
            @PathParam("name")String name, 
            @PathParam("score")int score,
            @PathParam("is_social")Boolean is_social) {
        
        Highscore highscore = new Highscore();
        highscore.setName(name);
        highscore.setScore(score);
        highscore.setIs_social(is_social);

        return highscoreMgr.insertHighscore(highscore);
    }
}
