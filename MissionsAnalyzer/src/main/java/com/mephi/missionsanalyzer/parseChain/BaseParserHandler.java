/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.parseChain;

import com.mephi.missionsanalyzer.parsersForEachType.Parser;
import java.io.FileNotFoundException;

/**
 *
 * @author panda
 */
public abstract class BaseParserHandler implements ParserHandler {
    protected ParserHandler next;
 
    protected abstract boolean canParse(String filePath) throws FileNotFoundException;
    protected abstract Parser createParser(String filePath);

    @Override
    public void setNext(ParserHandler next) {
        this.next = next;
    }

    @Override
    public Parser handle(String filePath) throws Exception {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("Путь к файлу не может быть пустым");
        }
        java.io.File file = new java.io.File(filePath);
        if (!file.exists()) {
            throw new java.io.FileNotFoundException("Файл не найден: " + filePath);
        }
        if (!file.isFile()) {
            throw new IllegalArgumentException("Это не файл: " + filePath);
        }
        if (!file.canRead()) {
            throw new IllegalArgumentException("Нет прав на чтение: " + filePath);
        }

        if (canParse(filePath)) {
            return createParser(filePath);
        }
        if (next != null) {
            return next.handle(filePath);
        }
        throw new Exception("Формат файла не поддерживается: " + filePath);
    }
}