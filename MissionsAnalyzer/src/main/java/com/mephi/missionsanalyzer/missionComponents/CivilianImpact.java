/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.mephi.missionsanalyzer.enums.PublicExposureRisk;

/**
 *
 * @author panda
 */
public class CivilianImpact {
    private int evacuated;
    private int injured;
    private int missing;
    private PublicExposureRisk publicExposureRisk;

    public int getEvacuated() {
        return evacuated;
    }

    public void setEvacuated(String evacuated) {
        this.evacuated = Integer.parseInt(evacuated);
    }

    public int getInjured() {
        return injured;
    }

    public void setInjured(String injured) {
        this.injured = Integer.parseInt(injured);
    }

    public int getMissing() {
        return missing;
    }

    public void setMissing(String missing) {
        this.missing = Integer.parseInt(missing);
    }

    public PublicExposureRisk getPublicExposureRisk() {
        return publicExposureRisk;
    }

    public void setPublicExposureRisk(PublicExposureRisk publicExposureRisk) {
        this.publicExposureRisk = publicExposureRisk;
    }
    
    
}
