/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mephi.missionsanalyzer.enums.Type;
import jakarta.persistence.*;

/**
 *
 * @author panda
 */
@Entity
public class Technique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonProperty("n")
    @JsonAlias({"name"})
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Type type;
    
    private String owner;
    private int damage;
    
    public Long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name=name;
    }
    
    public void setType(String type) {
        this.type=CheckForValue.parseEnum(Type.class, type);
    }
    
    public void setOwner(String owner) {
        this.owner=owner;
    }
    
    public void setDamage(String damage) {
        this.damage = CheckForValue.parseInt("damage", damage);
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Название техники: ")
          .append(CheckForValue.checkForNull(name))
          .append(", тип: ")
          .append(CheckForValue.checkForNull(type))
          .append(", владелец: ")
          .append(CheckForValue.checkForNull(owner));

        if (damage != 0) {
            sb.append(", урон: ");
            sb.append(damage);
        }

        sb.append("\n");
        return sb.toString();
    }
}
