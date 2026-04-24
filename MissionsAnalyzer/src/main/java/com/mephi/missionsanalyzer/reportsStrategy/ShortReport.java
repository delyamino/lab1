/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.reportsStrategy;

import com.mephi.missionsanalyzer.missionComponents.Mission;

/**
 *
 * @author panda
 */
public class ShortReport implements ReportStrategy {
    @Override
    public void report(Mission mission) {
        System.out.println("=== Краткий отчёт ===");
        System.out.println("ID: " + mission.getMissionId());
        System.out.println("Дата: " + mission.getDate());
        System.out.println("Локация: " + mission.getLocation());
        System.out.println("Исход: " + mission.getOutcome());
        mission.getCurse();
    }
}
