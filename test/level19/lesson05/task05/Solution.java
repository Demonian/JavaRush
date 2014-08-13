package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName0 = reader.readLine();
        String fileName1 = reader.readLine();

        FileReader fileReader = new FileReader(fileName0);
        FileWriter fileWriter = new FileWriter(fileName1);
        int tmp = 0;
        while ((tmp = fileReader.read()) != -1) if ((tmp < 33) || (tmp > 47 && tmp < 58) || (tmp > 64 && tmp < 91) || (tmp > 96 && tmp < 123)) fileWriter.write(tmp);
        fileReader.close();
        fileWriter.close();

    }
}
