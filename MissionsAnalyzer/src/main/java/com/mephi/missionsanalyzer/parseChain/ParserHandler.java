/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mephi.missionsanalyzer.parseChain;

import com.mephi.missionsanalyzer.parsersForEachType.Parser;

/**
 *
 * @author panda
 */
public interface ParserHandler {
    void setNext(ParserHandler next);
    Parser handle(String filePath) throws Exception;
}