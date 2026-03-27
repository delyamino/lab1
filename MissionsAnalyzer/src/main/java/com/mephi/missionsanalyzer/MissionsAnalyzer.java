/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mephi.missionsanalyzer;

import com.mephi.missionsanalyzer.factory.FileLoad;
import com.mephi.missionsanalyzer.factory.Parser;
import com.mephi.missionsanalyzer.factory.ParsersFabric;
import com.mephi.missionsanalyzer.missionComponents.Mission;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author panda
 */
public class MissionsAnalyzer {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            System.getLogger(MissionsAnalyzer.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }*/
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Введите путь к файлу миссии (f для выхода из программы): ");
            String path = scanner.nextLine();
            path = path.trim().replace("\"", "");
            
            if (path.equals("f")) {
                break;
            }
            
            FileLoad fl = new FileLoad();
            fl.setFilePath(path);

            ParsersFabric pf = new ParsersFabric();
            Parser parser = pf.getParser(fl);
            Mission mission = parser.parse();

            Output output = new Output();
            output.forPrint(mission);
        }
        scanner.close();
    }
}
