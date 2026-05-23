/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mephi.missionsanalyzer;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author panda
 */
@SpringBootApplication
public class MissionsAnalyzer {
    public static void main(String[] args) {
        SpringApplication.run(MissionsAnalyzer.class, args);
        
        /*try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Ошибка кодировки");
        }
        
        new ConsoleApp().run();*/
        
    }
}