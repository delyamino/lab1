/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.mephi.missionsanalyzer.enums.PublicExposureRisk;
import jakarta.persistence.*;

/**
 *
 * @author panda
 */
@Entity
public class CivilianImpact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int evacuated;
    private int injured;
    private int missing;
    
    @Enumerated(EnumType.STRING)
    private PublicExposureRisk publicExposureRisk;

    
    public Long getId() {
        return id;
    }
    
    public int getEvacuated() {
        return evacuated;
    }

    public void setEvacuated(String evacuated) {
        this.evacuated = CheckForValue.parseInt("evacuated", evacuated);
    }

    public int getInjured() {
        return injured;
    }

    public void setInjured(String injured) {
        this.injured = CheckForValue.parseInt("injured", injured);
    }

    public int getMissing() {
        return missing;
    }

    public void setMissing(String missing) {
        this.missing = CheckForValue.parseInt("missing", missing);
    }

    public PublicExposureRisk getPublicExposureRisk() {
        return publicExposureRisk;
    }

    public void setPublicExposureRisk(String publicExposureRisk) {
        this.publicExposureRisk = CheckForValue.parseEnum(PublicExposureRisk.class, publicExposureRisk);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Влияние на граждан: ");

        boolean hasData = false;

        if (evacuated != 0) {
            sb.append("эвакуировано: ").append(evacuated).append(", ");
            hasData = true;
        }

        if (injured != 0) {
            sb.append("пострадавшие: ").append(injured).append(", ");
            hasData = true;
        }

        if (missing != 0) {
            sb.append("пропавшие: ").append(missing).append(", ");
            hasData = true;
        }

        if (publicExposureRisk != null) {
            sb.append("риск раскрытия: ").append(publicExposureRisk);
            hasData = true;
        }

        return hasData ? sb.append("\n").toString() : "";
    }
}
