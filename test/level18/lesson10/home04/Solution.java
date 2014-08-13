package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
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

        FileInputStream inputStream0 = new FileInputStream(fileName0);
        FileInputStream inputStream1 = new FileInputStream(fileName1);

        byte[] buffer0 = null;
        int count0 = 0;
        byte[] buffer1 = null;
        int count1 = 0;
        if (inputStream0.available() > 0) {
            buffer0 = new byte[inputStream0.available()];
            count0 = inputStream0.read(buffer0);
        }
        if (inputStream1.available() > 0) {
            buffer1 = new byte[inputStream1.available()];
            count1 = inputStream1.read(buffer1);
        }
        inputStream0.close();
        inputStream1.close();

        FileOutputStream outputStream = new FileOutputStream(fileName0);
        outputStream.write(buffer1,0,count1);
        outputStream.write(buffer0,0,count0);
        outputStream.close();
    }
}
