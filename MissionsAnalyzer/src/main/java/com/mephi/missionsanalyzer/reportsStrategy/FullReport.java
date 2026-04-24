/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.reportsStrategy;

import com.mephi.missionsanalyzer.missionComponents.CivilianImpact;
import com.mephi.missionsanalyzer.missionComponents.EconomicAssessment;
import com.mephi.missionsanalyzer.missionComponents.EnemyActivity;
import com.mephi.missionsanalyzer.missionComponents.EnvironmentConditions;
import com.mephi.missionsanalyzer.missionComponents.Mission;
import com.mephi.missionsanalyzer.missionComponents.OperationTimeline;
import com.mephi.missionsanalyzer.missionComponents.Sorcerer;
import com.mephi.missionsanalyzer.missionComponents.Technique;
import com.mephi.missionsanalyzer.reportsStrategy.ReportStrategy;

/**
 *
 * @author panda
 */
public class FullReport implements ReportStrategy {
    @Override
    public void report(Mission mission) {
        System.out.println("=== Полный отчёт о миссии ===");
        System.out.print(mission); 
    }
}
