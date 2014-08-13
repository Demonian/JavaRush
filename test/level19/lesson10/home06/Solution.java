package com.javarush.test.level19.lesson10.home06;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одинадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        try
        {

            fileName = reader.readLine();
            reader.close();
            BufferedReader fileReader = null;
            try{
                fileReader = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e){
            }

            String line = "";
            StringBuilder sb = new StringBuilder();
            while ((line = fileReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    try{
                        int tmp = Integer.parseInt(word);
                        if (map.containsKey(tmp)) {
                            sb.append(map.get(tmp));
                            sb.append(" ");
                        }
                        else {
                            sb.append(tmp);
                            sb.append(" ");
                        }
                    } catch (NumberFormatException e){
                        sb.append(word);
                        sb.append(" ");
                    }
                }
                sb = new StringBuilder(sb.toString().trim());
                sb.append("\n\r");
            }
            System.out.print(sb.toString());
        } catch(IOException e) {
        }
    }
}
