package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line = "";
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) lines.add(line);
        reader.close();

        Map<String, Double> map = new TreeMap<String, Double>();
        for (String element : lines) {
            String[] str = element.split(" ");
            if (map.get(str[0]) == null) map.put(str[0],Double.parseDouble(str[1]));
            else map.put(str[0],map.get(str[0]) + Double.parseDouble(str[1]));
        }
        for (Map.Entry<String, Double> pair : map.entrySet()) System.out.println(pair.getKey() + " " + pair.getValue());


    }
}
