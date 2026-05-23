/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.controllers;

import com.mephi.missionsanalyzer.missionComponents.Mission;
import com.mephi.missionsanalyzer.reportsStrategy.*;
import com.mephi.missionsanalyzer.service.MissionsService;
import java.util.List;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author panda
 */
@RestController
@RequestMapping("/missions")
public class MissionsController {

    private MissionsService service;

    public MissionsController(MissionsService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public Mission upload(@RequestParam("path") String path) throws Exception {
        String cleanPath = path.trim().replace("\"", "");
        return service.upload(cleanPath);
    }

    @GetMapping
    public List<Mission> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mission one(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}/report")
    public String report(@PathVariable("id") Long id, @RequestParam(value = "type", defaultValue = "full") String type) {
        Mission m = service.getById(id);
        ReportContext ctx = new ReportContext(
            type.equals("short") ? new ShortReport() : new FullReport()
        );
        return ctx.generateReport(m);
    }
}
