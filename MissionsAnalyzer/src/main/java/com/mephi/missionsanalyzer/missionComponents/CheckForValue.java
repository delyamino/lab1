/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import java.util.Arrays;

/**
 *
 * @author panda
 */
public class CheckForValue {
    public static String checkForNull(Object value) {
        return value == null ? "Не указано" : value.toString();
    }
    
    public static String checkForZero(int value) {
        return value == 0 ? "Не указано" : String.valueOf(value);
    }  
    
    public static <E extends Enum<E>> E parseEnum(Class<E> enumClass, String value) {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException(
                "Значение для " + enumClass.getSimpleName() + " не может быть пустым");
        try {
            return Enum.valueOf(enumClass, value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                "Неверное значение \"" + value + "\" для " + enumClass.getSimpleName() + ", допустимые: " + Arrays.toString(enumClass.getEnumConstants()));
        }
    }

    public static int parseInt(String fieldName, String value) {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Поле " + fieldName + " не может быть пустым");
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "Поле " + fieldName + " должно быть целым числом");
        }
    }
}
