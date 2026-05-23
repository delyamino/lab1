/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 *
 * @author panda
 */
@Entity
public class OperationTimeline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime timestamp;
    private String type;
    private String description;
    
    public Long getId() {
        return id;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timeStamp) {
        if (timeStamp == null || timeStamp.isBlank()) {
            throw new IllegalArgumentException("Поле timestamp не может быть пустым");
        }

        try {
            this.timestamp = LocalDateTime.parse(timeStamp.trim()); 
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                "Неверный формат timestamp: \"" + timeStamp + "\". Ожидается yyyy-MM-ddTHH:mm:ss"
            );
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return  "    Время: " + CheckForValue.checkForNull(timestamp) + ", тип: " + CheckForValue.checkForNull(type) + ", описание: " + CheckForValue.checkForNull(description) + "\n";
    }
}
