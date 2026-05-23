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
    public String report(Mission mission) {
        StringBuilder sb = new StringBuilder();
        sb.append("Краткий отчёт о миссии");
        sb.append("ID: ").append(mission.getMissionId()).append("\n");
        sb.append("Дата: ").append(mission.getDate()).append("\n");
        sb.append("Локация: ").append(mission.getLocation()).append("\n");
        sb.append("Исход: ").append(mission.getOutcome()).append("\n");
        sb.append(mission.getCurse()).append("\n");
        return sb.toString();
    }
}
