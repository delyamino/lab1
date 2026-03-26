/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.mephi.missionsanalyzer.enums.Type;

/**
 *
 * @author panda
 */
public class Technique {      
    private String name;
    private Type type;
    private String owner;
    private int damage;
    
    public void setName(String name) {
        this.name=name;
    }
    
    public void setType(String type) {
        this.type=Type.valueOf(type);
    }
    
    public void setOwner(String owner) {
        this.owner=owner;
    }
    
    public void setDamage(String damage) {
        this.damage = Integer.parseInt(damage);
    }
    
    public String getName() {
        return name;
    }
    
    public Type getType() {
        return type;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public int getDamage() {
        return damage;
    }
}
