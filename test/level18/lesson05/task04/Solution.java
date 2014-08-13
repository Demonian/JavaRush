package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream inputStream1 = new FileInputStream(fileName1);
        FileOutputStream outputStream1= new FileOutputStream(fileName2);

        byte[] buffer = null;
        if(inputStream1.available() > 0){
            buffer = new byte[inputStream1.available()];
            int count = inputStream1.read(buffer);
            for (int i = count-1; i > -1; i--){
                outputStream1.write(buffer[i]);
            }
        }

        inputStream1.close();
        outputStream1.close();
    }
}
