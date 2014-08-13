package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        byte[] buffer = null;

        if (inputStream.available() > 0) {
            buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
        }
        inputStream.close();

        int count = 0;
        for (byte element : buffer) {
            if (element == 44) count++;
        }
        System.out.println(count);
    }
}
