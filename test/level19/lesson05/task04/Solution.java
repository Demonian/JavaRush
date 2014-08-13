package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
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
        while((tmp = fileReader.read()) != -1){
            if (tmp == 46) fileWriter.write(33);
            else fileWriter.write(tmp);
        }

        fileReader.close();
        fileWriter.close();
    }
}
