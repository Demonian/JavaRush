package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
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

        int i = 1;
        while (fileReader.ready()) {
            if (i%2 == 0) fileWriter.write(fileReader.read());
            else fileReader.skip(1);
            i++;
        }

        fileReader.close();
        fileWriter.close();

    }
}
