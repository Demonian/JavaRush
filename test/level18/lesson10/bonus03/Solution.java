package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        if ((args[0].charAt(1) != 'u') && (args[0].charAt(1) != 'd')) return;
        if (args[0].charAt(1) == 'u') update(createId(args),createProductName(args),createPrice(args),createQuantity(args),fileName);
        else delete(fileName,Integer.parseInt(args[1]));
    }

    private static String createId(String[] array){
        String tmp = array[1];
        if (tmp.length() > 8) tmp = tmp.substring(0,8);
        else {
            int tmpLength = tmp.length();
            for (int i = 0; i < 8 - tmpLength; i++) tmp += " ";
        }
        return tmp;
    }

    private static String createProductName(String[] array){
        String tmp = "";
        if (array.length > 5) {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < array.length - 2; i++) sb.append(array[i] + " ");
            tmp = sb.toString().trim();
        }
        else tmp = array[2];

        if (tmp.length() > 30) tmp = tmp.substring(0,30);
        else {
            int tmpLength = tmp.length();
            for (int i = 0; i < 30 - tmpLength; i++) tmp += " ";
        }
        return tmp;
    }

    private static String createPrice(String[] array){
        String tmp = array[array.length - 2];
        if (tmp.length() > 8) tmp = tmp.substring(0,8);
        else {
            int tmpLength = tmp.length();
            for (int i = 0; i < 8 - tmpLength; i++) tmp += " ";
        }
        return tmp;
    }

    private static String createQuantity(String[] array){
        String tmp = array[array.length - 1];
        if (tmp.length() > 4) tmp = tmp.substring(0,4);
        else {
            int tmpLength = tmp.length();
            for (int i = 0; i < 4 - tmpLength; i++) tmp += " ";
        }
        return tmp;
    }

    private static void update(String id, String productName, String price, String quantity, String fileName) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        int mainId = Integer.parseInt(id.trim());
        String line = "";
        List<String> allLines = new ArrayList<String>();
        boolean check = false;
        while ((line = bufferedReader.readLine()) != null) {
            int currentId = Integer.parseInt(line.substring(0,8).trim());
            if (currentId != mainId) allLines.add(line);
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(id);
                sb.append(productName);
                sb.append(price);
                sb.append(quantity);
                allLines.add(sb.toString());
                check = true;
            }
        }
        bufferedReader.close();
        if (check) writeData(allLines, fileName);
    }

    private static void delete(String fileName, int id) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = "";
        List<String> allLines = new ArrayList<String>();
        boolean check = false;
        while ((line = bufferedReader.readLine()) != null) {
            int currentId = Integer.parseInt(line.substring(0,8).trim());
            if (currentId != id) allLines.add(line);
            else check = true;
        }
        bufferedReader.close();
        if (check) writeData(allLines, fileName);
    }

    private static void writeData(List<String> allLines, String fileName) throws IOException{
        FileOutputStream outputStream = new FileOutputStream(fileName);
        for (String element : allLines ) {
            outputStream.write(element.getBytes());
            outputStream.write(10);
        }
        outputStream.close();
    }
}
