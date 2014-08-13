package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        //get a all text of file
        FileReader fileReader = new FileReader(fileName);
        int tmp = 0;
        StringBuilder sb = new StringBuilder();
        while ((tmp = fileReader.read()) != -1) sb.append(Character.toChars(tmp));

        String allLines = sb.toString();
        int index = 0, count = 0;
        while(index + 5 < allLines.length()) {
            index = allLines.indexOf("world",index) + 5;
            count++;
        }
        fileReader.close();

        System.out.print(count);
    }
}
