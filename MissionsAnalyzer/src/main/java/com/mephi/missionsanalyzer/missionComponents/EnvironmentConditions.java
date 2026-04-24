/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.mephi.missionsanalyzer.enums.Visibility;

/**
 *
 * @author panda
 */
public class EnvironmentConditions {
    private String weather;
    private String timeOfDay;
    private Visibility visibility;
    private int cursedEnergyDensity;

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = CheckForValue.parseEnum(Visibility.class, visibility);
    }

    public int getCursedEnergyDensity() {
        return cursedEnergyDensity;
    }

    public void setCursedEnergyDensity(String cursedEnergyDensity) {
        this.cursedEnergyDensity = CheckForValue.parseInt("cursedEnergyDensity", cursedEnergyDensity);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Условия среды: ");

        boolean hasData = false;

        if (weather != null) {
            sb.append("погода: ").append(weather).append(", ");
            hasData = true;
        }

        if (timeOfDay != null) {
            sb.append("время суток: ").append(timeOfDay).append(", ");
            hasData = true;
        }

        if (visibility != null) {
            sb.append("видимость: ").append(visibility).append(", ");
            hasData = true;
        }

        if (cursedEnergyDensity != 0) {
            sb.append("плотность энергии: ").append(cursedEnergyDensity);
            hasData = true;
        }

        return hasData ? sb.append("\n").toString() : "";
    }
}
