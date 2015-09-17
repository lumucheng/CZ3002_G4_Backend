/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntu.cz3002.entity;

import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "question")
@XmlType(propOrder = {"id", "image", "answer", "tag", "wrong_answers" } )
public class Question {
    
    private int id;
    private String image;
    private String answer;
    private String tag;
    private ArrayList<String> wrong_answers;
    private InputStream inputStream;
    
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

    @XmlElement
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @XmlElement
    public ArrayList<String> getWrong_answers() {
        return wrong_answers;
    }

    public void setWrong_answers(ArrayList<String> wrong_answers) {
        this.wrong_answers = wrong_answers;
    }

    @XmlTransient
    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
