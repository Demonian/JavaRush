package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = null;
        Map<Integer, byte[]> filesData = new HashMap<Integer, byte[]>();

        byte[] buffer = null;
        String fileName = "";
        String[] tmp = null;

        boolean check = false;
        String[] forWrite = null;

        while(true){
            fileName = reader.readLine();
            if (fileName.equals("end")) break;
            tmp = fileName.split("part");

            if (!check) {
                forWrite = fileName.split(".part" + tmp[tmp.length -1]);
                check = true;
            }

            inputStream = new FileInputStream(fileName);
            if (inputStream.available() > 0) {
                buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                filesData.put(Integer.parseInt(tmp[tmp.length - 1]),buffer);
            }
            inputStream.close();
        }

        FileOutputStream outputStream = new FileOutputStream(forWrite[0]);
        for (int i = 1; i < filesData.size() + 1; i++) outputStream.write(filesData.get(i));
        outputStream.close();
    }
}
