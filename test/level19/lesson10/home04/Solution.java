package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        try{

            fileName = reader.readLine();
            reader.close();
            BufferedReader fileReader = null;
            try{
               fileReader = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e){
            }
            String line = "";
            while ((line = fileReader.readLine()) != null) {
               int count = 0;
               for (String element : words) if (line.indexOf(element) != -1) count++;
               if (count == 2) System.out.println(line);
            }
            fileReader.close();
        } catch (IOException e){
        }
    }
}
