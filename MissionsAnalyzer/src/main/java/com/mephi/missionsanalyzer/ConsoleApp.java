/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer;
import com.mephi.missionsanalyzer.parseChain.JsonHandler;
import com.mephi.missionsanalyzer.parseChain.XMLHandler;
import com.mephi.missionsanalyzer.parseChain.YamlHandler;
import com.mephi.missionsanalyzer.parseChain.TxtHandler;
import com.mephi.missionsanalyzer.parseChain.Txt2Handler;
import com.mephi.missionsanalyzer.parseChain.BinaryHandler;
import com.mephi.missionsanalyzer.parseChain.ParserHandler;
import com.mephi.missionsanalyzer.missionComponents.Mission;
import com.mephi.missionsanalyzer.parsersForEachType.Parser;
import java.util.Scanner;
import com.mephi.missionsanalyzer.reportsStrategy.FullReport;
import com.mephi.missionsanalyzer.reportsStrategy.ReportContext;
import com.mephi.missionsanalyzer.reportsStrategy.ReportStrategy;
import com.mephi.missionsanalyzer.reportsStrategy.ShortReport;

/**
 *
 * @author panda
 */


public class ConsoleApp {
    private final ParserHandler parserChain;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleApp() {
        this.parserChain = buildChain();
    }

    public void run() {
        ReportContext reportContext = new ReportContext(chooseReport());
        System.out.println("Введите 'exit' для выхода\n");

        while (true) {
            String path = readPath();
            if (path.equalsIgnoreCase("exit")) {
                System.out.println("Выход.");
                break;
            }
            try {
                Mission mission = loadMission(path);
                handleReportLoop(mission, reportContext);
            } catch (IllegalStateException e) {
                System.out.println("Ошибка валидации: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Неверное значение поля: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private String readPath() {
        System.out.print("Введите путь к файлу: ");
        return scanner.nextLine().trim().replace("\"", "");
    }

    private Mission loadMission(String path) throws Exception {
        Parser parser = parserChain.handle(path);
        return parser.parse();
    }

    private void handleReportLoop(Mission mission, ReportContext reportContext) {
        while (true) {
            System.out.println("\nОТЧЁТ");
            reportContext.executeReport(mission);
            System.out.println("\n1 - сменить тип отчёта");
            System.out.println("2 - загрузить новый файл");
            System.out.println("exit - выход");

            switch (scanner.nextLine().trim()) {
                case "1" -> reportContext.setStrategy(chooseReport());
                case "2" -> { return; } 
                default  -> {
                    if (scanner.nextLine().trim().equalsIgnoreCase("exit")) {
                        System.out.println("Выход.");
                        System.exit(0);
                    } else {
                        System.out.println("Неизвестная команда");
                    }
                }
            }
        }
    }

    private ReportStrategy chooseReport() {
        System.out.println("Выберите тип отчёта:");
        System.out.println("  1 - краткий");
        System.out.println("  2 - полный");
        String choice = scanner.nextLine().trim();
        return switch (choice) {
            case "1" -> new ShortReport();
            default  -> {
                if (!choice.equals("2"))
                    System.out.println("Неизвестный выбор — выбран полный отчёт");
                yield new FullReport();
            }
        };
    }

    private ParserHandler buildChain() {
        ParserHandler json = new JsonHandler();
        ParserHandler xml  = new XMLHandler();
        ParserHandler yaml = new YamlHandler();
        ParserHandler txt1 = new TxtHandler();
        ParserHandler txt2 = new Txt2Handler();
        ParserHandler bin  = new BinaryHandler();

        json.setNext(xml);
        xml.setNext(yaml);
        yaml.setNext(txt1);
        txt1.setNext(txt2);
        txt2.setNext(bin);

        return json;
    }
}