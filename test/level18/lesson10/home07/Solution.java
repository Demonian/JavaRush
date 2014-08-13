package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String str = "";
        List<String> lines = new ArrayList<String>();
        while((str = fileReader.readLine()) != null) lines.add(str);

            for (String line : lines) if (id(line) == Integer.parseInt(args[0])) {
                System.out.print(line);
                break;
            }
        fileReader.close();
    }

    public static int id(String line){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length(); i++){
                if (line.charAt(i) != ' ') sb.append(line.charAt(i));
                else return Integer.parseInt(sb.toString());
            }
        return -1;
    }
}
