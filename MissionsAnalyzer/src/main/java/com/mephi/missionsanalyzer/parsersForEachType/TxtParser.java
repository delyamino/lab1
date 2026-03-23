/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.parsersForEachType;

import com.mephi.missionsanalyzer.factory.Parser;
import com.mephi.missionsanalyzer.factory.FileLoad;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author panda
 */
public class TxtParser implements Parser{
    @Override
    public String parse(FileLoad fl){
        InputStream stream = fl.getFile();
        List<Products> products=new ArrayList<>();
        length=stream.available();
        byte[] data=new byte[length];
        stream.read(data);
        String text=new String(data,"CP1251");
        String[] lines=text.split("\n");

        for (String line:lines) {
            String[] words=line.split(";");
            String name=words[0];
        }
