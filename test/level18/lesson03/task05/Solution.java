package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        List<Integer> fileBytes = new ArrayList<Integer>();

        while(inputStream.available() > 0){
            fileBytes.add(inputStream.read());
        }

        Set<Integer> set = new TreeSet<Integer>();
        for (Integer element : fileBytes) {
            set.add(element);
        }

        String result = set.toString();
        result = result.substring(1,result.length() - 1);
        String[] tmp = result.split(",");
        StringBuilder sb = new StringBuilder();
        for (String element : tmp) {
            sb.append(element);
        }
        result = sb.toString();

        System.out.print((result + " ").trim());
        inputStream.close();
    }
}
