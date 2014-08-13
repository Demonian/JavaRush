package com.javarush.test.level19.lesson10.bonus01;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName0 = "";
        String fileName1 = "";
        try{
            fileName0 = reader.readLine();
            fileName1 = reader.readLine();
            reader.close();
        } catch (IOException e) {
        }

        BufferedReader fileReader0 = null;
        BufferedReader fileReader1 = null;

        try{
            String line = "";
            fileReader0 = new BufferedReader(new FileReader(fileName0));
            List<String> fileOneLines = new ArrayList<String>();
            while ((line = fileReader0.readLine()) != null) fileOneLines.add(line);
            fileReader0.close();

            fileReader1 = new BufferedReader(new FileReader(fileName1));
            List<String> fileTwoLines = new ArrayList<String>();
            while ((line = fileReader1.readLine()) != null) fileTwoLines.add(line);
            fileReader1.close();

            while (!fileTwoLines.isEmpty())
            {
                try{
                if (fileTwoLines.get(0).equals(fileOneLines.get(0))){
                    lines.add(new LineItem(Type.SAME, fileTwoLines.get(0)));
                    fileOneLines.remove(0);
                    fileTwoLines.remove(0);
                }
                else if (!fileTwoLines.isEmpty() && !fileOneLines.contains(fileTwoLines.get(0))){
                    lines.add(new LineItem(Type.ADDED, fileTwoLines.get(0)));
                    fileTwoLines.remove(0);
                    }
                    else{
                    lines.add(new LineItem(Type.REMOVED, fileOneLines.get(0)));
                    fileOneLines.remove(0);
                }
                } catch (IndexOutOfBoundsException e) {
                    lines.add(new LineItem(Type.ADDED, fileTwoLines.get(0)));
                    fileTwoLines.remove(0);
                }
            }
            if (!fileOneLines.isEmpty()) lines.add(new LineItem(Type.REMOVED, fileOneLines.get(0)));

        } catch (IOException e){
        }

        for (LineItem element : lines) System.out.println(element.type + " " + element.line);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
