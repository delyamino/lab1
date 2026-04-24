/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mephi.missionsanalyzer;

import ParseChain.BinaryHandler;
import ParseChain.JsonHandler;
import ParseChain.ParserHandler;
import ParseChain.Txt2Handler;
import ParseChain.TxtHandler;
import ParseChain.XMLHandler;
import ParseChain.YamlHandler;
import com.mephi.missionsanalyzer.parsersForEachType.Parser;
import com.mephi.missionsanalyzer.missionComponents.Mission;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author panda
 */
public class MissionsAnalyzer {
    public static void main(String[] args) {
        /*try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Ошибка кодировки");
        }*/
        
        new ConsoleApp().run();
    }
}