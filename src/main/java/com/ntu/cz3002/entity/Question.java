/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntu.cz3002.entity;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "question")
@XmlType(propOrder = {"id", "image_url", "answer", "tag", } )
public class Question {
    
    private int id;
    private String image_path;
    private String image_url;
    private String image_name;
    private String answer;
    private String tag;
    private ArrayList<String> wrong_answers;
    
    public Question() {
        wrong_answers = new ArrayList<String>();
    }
    
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @XmlTransient
    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    @XmlElement
    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image) {
        this.image_url = image;
    }
    
    @XmlTransient
    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    @XmlElement
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @XmlElement
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }   

    @XmlTransient
    public ArrayList<String> getWrong_answers() {
        return wrong_answers;
    }

    public void setWrong_answers(ArrayList<String> wrong_answers) {
        this.wrong_answers = wrong_answers;
    }
}
