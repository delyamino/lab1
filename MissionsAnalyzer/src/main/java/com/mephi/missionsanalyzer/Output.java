package com.mephi.missionsanalyzer;

import com.mephi.missionsanalyzer.missionComponents.Mission;
import com.mephi.missionsanalyzer.missionComponents.Sorcerer;
import com.mephi.missionsanalyzer.missionComponents.Technique;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author panda
 */
public class Output {
    public void forPrint (Mission mission) {
        System.out.println("Миссия:");
        System.out.println("  ID: " + mission.getMissionId());
        System.out.println("  ДАТА: " + mission.getDate());
        System.out.println("  ЛОКАЦИЯ: " + mission.getLocation());
        System.out.println("  ИСХОД: " + mission.getOutcome());
        System.out.println("  УЩЕРБ: " + mission.getDamageCost());
        
        System.out.println("\nПроклятие:");
        System.out.println("  НАЗВАНИЕ: " + mission.getCurse().getName());
        System.out.println("  УРОВЕНЬ УГРОЗЫ: " + mission.getCurse().getThreatLevel());
        
        System.out.println("\nМаги:");
        for (Sorcerer s : mission.getSorcerers()) {
            System.out.println("  ИМЯ: " + s.getName() + ", РАНГ:" + s.getRank());
        }
        
        System.out.println("\nТехники:");
        for (Technique t : mission.getTechniques()) {
            System.out.println("  НАЗВАНИЕ: " + t.getName() + ", ТИП: " + t.getType() + ", УРОН: " + t.getDamage() + ", ВЛАДЕЛЕЦ: " + t.getOwner());
        }
        
        if (mission.getComment() != null) {
            System.out.println("\nКомментарий: " + mission.getComment());
        }
        else if (mission.getNote() != null) {
            System.out.println("\nЗаметка: " + mission.getNote());
        }
    }
}
