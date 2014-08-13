package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма. Имена разделять пробелом
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line = "";
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) lines.add(line);
        reader.close();

        Map<String, Double> map = new HashMap<String, Double>();
        for (String element : lines) {
            String[] str = element.split(" ");
            if (map.get(str[0]) == null) map.put(str[0],Double.parseDouble(str[1]));
            else map.put(str[0],map.get(str[0]) + Double.parseDouble(str[1]));
        }
        maxHashMapValueKeyOut(map);

    }

    private static void maxHashMapValueKeyOut(Map<String, Double> map){
        double max = Double.MIN_VALUE;
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() > max) {
                max = pair.getValue();
                list.clear();
                list.add(pair.getKey());
            }
            else if (pair.getValue() == max) list.add(pair.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (String element : list) {
            sb.append(element);
            sb.append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}
