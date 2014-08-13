package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
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
        int tmp = 0;
        StringBuilder buffer = new StringBuilder();
        /*
        StringBuilder result = new StringBuilder();
        boolean check = false;
        while ((tmp = fileReader.read()) != -1) {
            if (tmp > 47 && tmp < 58 && !check) {
                if (check) check = false;
                buffer.append(Character.toChars(tmp));
            }
            else if ((tmp > 64 && tmp < 91) || (tmp > 96 && tmp < 123)) {
                check = true;
                buffer = new StringBuilder();
                }
                else if (!"".equals(buffer.toString())){
                    result.append(buffer.toString());
                    result.append(" ");
                    buffer = new StringBuilder();
                    }
                    else if (check) check = false;
        }
        if (!"".equals(buffer.toString())) result.append(buffer.toString());*/
        while ((tmp = fileReader.read()) != -1) buffer.append(Character.toChars(tmp));
        fileReader.close();

        String[] strArray = buffer.toString().split(" ");
        buffer = new StringBuilder();
        for (String element : strArray) {
            try{
                int var = Integer.parseInt(element);
                buffer.append(var);
                buffer.append(" ");
            } catch (NumberFormatException e){
            }
        }

        String output = buffer.toString().trim();
        FileWriter fileWriter = new FileWriter(fileName1);
        fileWriter.write(output,0,output.length());
        fileWriter.close();
    }
}
