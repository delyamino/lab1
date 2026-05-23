/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.service;

import com.mephi.missionsanalyzer.parseChain.ParserHandler;
import com.mephi.missionsanalyzer.missionComponents.Mission;
import com.mephi.missionsanalyzer.parsersForEachType.Parser;
import java.util.List;
import com.mephi.missionsanalyzer.repository.MissionRepository;
import com.mephi.missionsanalyzer.ConsoleApp;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author panda
 */
@Service
public class MissionsService {

    private MissionRepository repository;
    private ParserHandler parserChain;

    public MissionsService(MissionRepository repository) {
        this.repository = repository;
        
        ConsoleApp ca = new ConsoleApp();
        this.parserChain = (ParserHandler) ca.buildChain();
    }

    public Mission upload(String path) throws Exception {
        Parser parser = parserChain.handle(path);
        Mission mission = parser.parse();
        
        Optional<Mission> oldMission = repository.findByMissionId(mission.getMissionId());
        
        if (oldMission.isPresent()) {
            Mission missionToUpdate = oldMission.get();
            updateMissionFields(missionToUpdate, mission);
            return repository.save(missionToUpdate);
        } else {
            return repository.save(mission);
        }
    }

    public List<Mission> getAll() {
        return repository.findAll();
    }

    public Mission getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    
    private void updateMissionFields(Mission oldMission, Mission newMission) {
        oldMission.setDate(newMission.getDate());
        oldMission.setLocation(newMission.getLocation());
        oldMission.setOutcome(newMission.getOutcome());
        oldMission.setDamageCost(newMission.getDamageCost());
        oldMission.setNote(newMission.getNote());
        oldMission.setComment(newMission.getComment());

        if (newMission.getCurse() != null) {
            oldMission.setCurse(newMission.getCurse());
        }           
        if (newMission.getEconomicAssessment() != null) {
            oldMission.setEconomicAssessment(newMission.getEconomicAssessment());
        }
        if (newMission.getCivilianImpact() != null) {
            oldMission.setCivilianImpact(newMission.getCivilianImpact());
        }
        if (newMission.getEnemyActivity() != null) {
            oldMission.setEnemyActivity(newMission.getEnemyActivity());
        }
        if (newMission.getEnvironmentConditions() != null) {
            oldMission.setEnvironmentConditions(newMission.getEnvironmentConditions());
        }

        if (newMission.getSorcerers() != null) {
            oldMission.getSorcerers().clear();
            oldMission.getSorcerers().addAll(newMission.getSorcerers());
        }
        if (newMission.getTechniques() != null) {
            oldMission.getTechniques().clear();
            oldMission.getTechniques().addAll(newMission.getTechniques());
        }
        if (newMission.getOperationTimelines() != null) {
            oldMission.getOperationTimelines().clear();
            oldMission.getOperationTimelines().addAll(newMission.getOperationTimelines());
        }

        if (newMission.getOperationTags() != null) {
            oldMission.getOperationTags().clear();
            oldMission.getOperationTags().addAll(newMission.getOperationTags());
        }
        if (newMission.getSupportUnits() != null) {
            oldMission.getSupportUnits().clear();
            oldMission.getSupportUnits().addAll(newMission.getSupportUnits());
        }
        if (newMission.getRecommendations() != null) {
            oldMission.getRecommendations().clear();
            oldMission.getRecommendations().addAll(newMission.getRecommendations());
        }
        if (newMission.getArtifactsRecovered() != null) {
            oldMission.getArtifactsRecovered().clear();
            oldMission.getArtifactsRecovered().addAll(newMission.getArtifactsRecovered());
        }
        if (newMission.getEvacuationZones() != null) {
            oldMission.getEvacuationZones().clear();
            oldMission.getEvacuationZones().addAll(newMission.getEvacuationZones());
        }
        if (newMission.getStatusEffects() != null) {
            oldMission.getStatusEffects().clear();
            oldMission.getStatusEffects().addAll(newMission.getStatusEffects());
        }
    }            
}