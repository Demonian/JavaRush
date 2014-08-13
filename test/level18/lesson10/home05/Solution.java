package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName0 = reader.readLine();
        String fileName1 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName0);
        byte[] buffer = null;
        if (inputStream.available() > 0) {
            buffer = new byte[inputStream.available()];
            inputStream.read(buffer);

            StringBuilder sb = new StringBuilder();
            FileOutputStream outputStream = new FileOutputStream(fileName1);
            for (byte element : buffer) sb.append(Character.toChars(element)[0]);
            String[] tmp = sb.toString().split(" ");

            for (String element : tmp) {
                String _tmp = ((Integer)Math.round(Float.parseFloat(element))).toString();
                for (int i = 0; i < _tmp.length(); i++) outputStream.write(_tmp.codePointAt(i));
                outputStream.write(" ".codePointAt(0));
            }
            outputStream.close();

        }
        inputStream.close();
    }
}
