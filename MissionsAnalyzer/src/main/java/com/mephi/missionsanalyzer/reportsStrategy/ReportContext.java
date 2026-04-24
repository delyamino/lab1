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

public class ReportContext {
    private ReportStrategy strategy;

    public ReportContext(ReportStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ReportStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeReport(Mission mission) {
        strategy.report(mission);
    }
}