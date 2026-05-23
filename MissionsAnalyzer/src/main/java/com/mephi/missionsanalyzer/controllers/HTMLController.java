/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.controllers;

import com.mephi.missionsanalyzer.service.MissionsService;
import com.mephi.missionsanalyzer.missionComponents.Mission;
import com.mephi.missionsanalyzer.reportsStrategy.*;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author panda
 */
@Controller
public class HTMLController {

    private MissionsService service;

    public HTMLController(MissionsService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("path") String path) throws Exception{
            String cleanPath = path.trim().replace("\"", "");
            service.upload(cleanPath); 
            return "redirect:/missions-view";
    }

    @GetMapping("/missions-view")
    public String all(Model model) {
        List<Mission> missions = service.getAll();
        model.addAttribute("missions", missions);
        return "missions";
    }

    @GetMapping("/report/{id}")
    public String report(@PathVariable("id") Long id, @RequestParam(value = "type", defaultValue = "full") String type, Model model) {
        Mission mission = service.getById(id);
        ReportStrategy strategy = type.equals("short") ? new ShortReport() : new FullReport();
        ReportContext context = new ReportContext(strategy);
        context.generateReport(mission);
        String reportContent = context.generateReport(mission);
        
        model.addAttribute("report", reportContent);
        return "report";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/missions-view";
    }
}
