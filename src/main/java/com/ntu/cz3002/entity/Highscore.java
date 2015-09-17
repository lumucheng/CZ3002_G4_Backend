/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntu.cz3002.entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "highscore")
@XmlType(propOrder = {"name", "score", "is_social", "last_update", } )
public class Highscore {
    
    private String name;
    private int score;
    private Boolean is_social;
    private Date last_update;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @XmlElement
    public Boolean getIs_social() {
        return is_social;
    }

    public void setIs_social(Boolean is_social) {
        this.is_social = is_social;
    }

    @XmlElement
    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }    
}
