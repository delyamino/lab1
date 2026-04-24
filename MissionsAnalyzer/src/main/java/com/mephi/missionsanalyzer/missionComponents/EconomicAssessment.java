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
    private Boolean insuranceCovered;

    public int getTotalDamageCost() {
        return totalDamageCost;
    }

    public void setTotalDamageCost(String totalDamageCost) {
        this.totalDamageCost = CheckForValue.parseInt("totalDamageCost", totalDamageCost);
    }

    public int getInfrastructureDamage() {
        return infrastructureDamage;
    }

    public void setInfrastructureDamage(String infrastructureDamage) {
        this.infrastructureDamage = CheckForValue.parseInt("infrastructureDamage", infrastructureDamage);
    }

    public int getCommercialDamage() {
        return commercialDamage;
    }

    public void setCommercialDamage(String commercialDamage) {
        this.commercialDamage = CheckForValue.parseInt("commercialDamage", commercialDamage);
    }

    public int getTransportDamage() {
        return transportDamage;
    }

    public void setTransportDamage(String transportDamage) {
        this.transportDamage = CheckForValue.parseInt("transportDamage", transportDamage);
    }

    public int getRecoveryEstimateDays() {
        return recoveryEstimateDays;
    }

    public void setRecoveryEstimateDays(String recoveryEstimateDays) {
        this.recoveryEstimateDays = CheckForValue.parseInt("recoveryEstimateDays", recoveryEstimateDays);
    }

    public boolean getInsuranceCovered() {
        return insuranceCovered;
    }

    public void setInsuranceCovered(String insuranceCovered) {
        this.insuranceCovered = Boolean.parseBoolean(insuranceCovered.trim());
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Экономическая оценка: ");

        boolean hasData = false;

        if (totalDamageCost != 0) {
            sb.append("общий ущерб: ").append(totalDamageCost).append(", ");
            hasData = true;
        }

        if (infrastructureDamage != 0) {
            sb.append("инфраструктура: ").append(infrastructureDamage).append(", ");
            hasData = true;
        }

        if (commercialDamage != 0) {
            sb.append("коммерческий ущерб: ").append(commercialDamage).append(", ");
            hasData = true;
        }

        if (transportDamage != 0) {
            sb.append("транспорт: ").append(transportDamage).append(", ");
            hasData = true;
        }

        if (recoveryEstimateDays != 0) {
            sb.append("восстановление (дни): ").append(recoveryEstimateDays).append(", ");
            hasData = true;
        }

        if (insuranceCovered != null) {
            sb.append("страховка: ").append(insuranceCovered);
            hasData = true;
        }

        return hasData ? sb.append("\n").toString() : "";
    }
}
