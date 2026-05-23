/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mephi.missionsanalyzer.enums.Rank;
import jakarta.persistence.*;

/**
 *
 * @author panda
 */
@Entity
public class Sorcerer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonProperty("n")
    @JsonAlias({"name"})
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Rank rank;
    
    public Long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name=name;
    }
    
    public void setRank(String rank) {
        this.rank=CheckForValue.parseEnum(Rank.class, rank);
    }
    
    public String getName() {
        return name;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    @Override
    public String toString() {
        return "Имя мага: " + CheckForValue.checkForNull(name) + ", ранг: " + CheckForValue.checkForNull(rank) + "\n";
    }
}
