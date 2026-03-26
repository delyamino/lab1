/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mephi.missionsanalyzer.factory;

import com.mephi.missionsanalyzer.missionComponents.Mission;
import java.io.IOException;

/**
 *
 * @author panda
 */
public interface Parser {
    Mission parse() throws IOException;
}
