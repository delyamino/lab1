/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.repository;

import com.mephi.missionsanalyzer.missionComponents.Mission;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author panda
 */

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    Optional<Mission> findByMissionId(String missionId);
}
