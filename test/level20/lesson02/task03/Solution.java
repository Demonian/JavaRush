package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<String, String>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        try {
        fileName = reader.readLine();
        load(new FileInputStream(fileName));
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        for (Map.Entry<String, String> pair : properties.entrySet()) p.setProperty(pair.getKey(), pair.getValue());
        p.store(outputStream,"");
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.load(inputStream);
        Enumeration e = p.propertyNames();
        while (e.hasMoreElements()) {
            String tmp = e.nextElement().toString();
            properties.put(tmp,p.getProperty(tmp));
        }
        inputStream.close();
    }
}
