package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        FileOutputStream outputStream1 = new FileOutputStream(fileName1);
        FileInputStream inputStream2 = new FileInputStream(fileName2);
        FileInputStream inputStream3 = new FileInputStream(fileName3);

        byte[] buffer = null;
        if (inputStream2.available() > 0){
            buffer = new byte[inputStream2.available()];
            int count = inputStream2.read(buffer);
            outputStream1.write(buffer,0,count);
            if (inputStream3.available() > 0) {
                buffer = new byte[inputStream3.available()];
                int count2 = inputStream3.read(buffer);
                outputStream1.write(buffer,0,count2);
            }
        }
        outputStream1.close();
        inputStream2.close();
        inputStream3.close();
    }
}
