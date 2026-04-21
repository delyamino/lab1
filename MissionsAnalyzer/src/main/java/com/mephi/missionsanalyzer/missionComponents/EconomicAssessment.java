/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

/**
 *
 * @author panda
 */
public class EconomicAssessment {
    private int totalDamageCost;
    private int infrastructureDamage;
    private int commercialDamage;
    private int transportDamage;
    private int recoveryEstimateDays;
    private boolean insuranceCovered;

    public int getTotalDamageCost() {
        return totalDamageCost;
    }

    public void setTotalDamageCost(String totalDamageCost) {
        this.totalDamageCost = Integer.parseInt(totalDamageCost);
    }

    public int getInfrastructureDamage() {
        return infrastructureDamage;
    }

    public void setInfrastructureDamage(String infrastructureDamage) {
        this.infrastructureDamage = Integer.parseInt(infrastructureDamage);
    }

    public int getCommercialDamage() {
        return commercialDamage;
    }

    public void setCommercialDamage(String commercialDamage) {
        this.commercialDamage = Integer.parseInt(commercialDamage);
    }

    public int getTransportDamage() {
        return transportDamage;
    }

    public void setTransportDamage(String transportDamage) {
        this.transportDamage = Integer.parseInt(transportDamage);
    }

    public int getRecoveryEstimateDays() {
        return recoveryEstimateDays;
    }

    public void setRecoveryEstimateDays(String recoveryEstimateDays) {
        this.recoveryEstimateDays = Integer.parseInt(recoveryEstimateDays);
    }

    public boolean getInsuranceCovered() {
        return insuranceCovered;
    }

    public void setInsuranceCovered(String insuranceCovered) {
        this.insuranceCovered = Boolean.parseBoolean(insuranceCovered);
    }
}
