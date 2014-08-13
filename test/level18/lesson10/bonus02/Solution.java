package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-с  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

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
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        if (args[0].charAt(1) != 'c') return;
        writeStringData(createId(fileName),createProductName(args),createPrice(args),createQuantity(args),fileName);
    }

    private static boolean fileCheck(String fileName) throws Exception{
        FileInputStream inputStream = new FileInputStream(fileName);
        if (inputStream.available() > 0) {
            inputStream.close();
            return true;
        }
        else {
            inputStream.close();
            return false;
        }
    }

    private static byte[] createId(String fileName) throws Exception{
        if (!fileCheck(fileName)) return "1       ".getBytes();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = "";
        //read last id
        List<String> lines = new ArrayList<String>();
        while ((line = bufferedReader.readLine()) != null) lines.add(line);
        bufferedReader.close();
        //create new id
        Integer currentId = Integer.parseInt(lines.get(lines.size() - 1).substring(0,8).trim());
        String tmp = (++currentId).toString();
        int tmpLength = tmp.length();
        for (int i = 0; i < 8 - tmpLength; i++) tmp += " ";
        return tmp.getBytes();
    }

    private static byte[] createProductName(String[] array){
        String productName = "";
        if (array.length > 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < array.length - 2; i++) sb.append(array[i] + " ");
            productName = sb.toString().trim();
        }
        else productName = array[1];
        if (productName.length() > 30) productName = productName.substring(0,30);
        else {
            int tmpLength = productName.length();
            for (int i = 0; i < 30 - tmpLength; i++) productName += " ";
        }
        return productName.getBytes();
    }

    private static byte[] createPrice(String[] array){
        String tmp = array[array.length - 2];
        if (tmp.length() > 8) tmp = tmp.substring(0,8);
        else {
            int tmpLength = tmp.length();
            for (int i = 0; i < 8 - tmpLength; i++) tmp += " ";
        }
        return tmp.getBytes();
    }

    private static byte[] createQuantity(String[] array){
        String tmp = array[array.length - 1];
        if (tmp.length() > 4) tmp = tmp.substring(0,4);
        else {
            int tmpLength = tmp.length();
            for (int i = 0; i < 4 - tmpLength; i++) tmp += " ";
        }
        return tmp.getBytes();
    }

    private static void writeStringData(byte[] id, byte[] productName, byte[] price, byte[] quantity, String fileName) throws IOException{
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        randomAccessFile.skipBytes((int)randomAccessFile.length());
        randomAccessFile.write(id);
        randomAccessFile.write(productName);
        randomAccessFile.write(price);
        randomAccessFile.write(quantity);
        randomAccessFile.write(10);
        randomAccessFile.close();
    }

}
