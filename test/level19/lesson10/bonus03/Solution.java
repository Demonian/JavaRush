package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;
        StringBuilder data = new StringBuilder();

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = "";
            fileName = reader.readLine();
            reader.close();



            String line = "";
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) data.append(line);
            fileReader.close();
        } catch (IOException e){
        }

        searchTag(args[0], data);
    }

    private static void searchTag(String tag, StringBuilder data){
        List<String> tags = new ArrayList<String>();

        String searchPhrase = "<" + tag;
        String closePhrase = "</" + tag + ">";
        int lastPosition = 0;

        while (data.indexOf(searchPhrase, lastPosition) != -1) {
            List<Integer> open = new LinkedList<Integer>();
            List<Integer> close = new LinkedList<Integer>();

            int start = data.indexOf(searchPhrase,lastPosition);
            int end = data.indexOf(closePhrase,lastPosition);

            open.add(start);
            close.add(end);

            while (true) {
                int index = data.indexOf(searchPhrase, start + searchPhrase.length());
                if (index < end && index != -1) {
                    open.add(index);
                    start = index;
                    close.add(data.indexOf(closePhrase, end + closePhrase.length()));
                    end = data.indexOf(closePhrase, end + closePhrase.length());
                }
                else break;
            }
            lastPosition = end + closePhrase.length();

            for (int i = 0; i < open.size(); i++) tags.add(data.substring(open.get(i),close.get(close.size() - (i + 1)) + closePhrase.length()));
        }

        for (String line : tags) System.out.println(line);
    }
}
