package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while(inputStream.available() > 0){
            int tmp = inputStream.read();
            if (map.containsKey(tmp)) map.put(tmp,map.get(tmp) + 1);
            else map.put(tmp,1);
        }
        inputStream.close();

        List<Integer> minBytes = new ArrayList<Integer>();
        int minEntry = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() < minEntry) {
                minEntry = pair.getValue();
                minBytes.clear();
                minBytes.add(pair.getKey());
            }
            else if (pair.getValue() == minEntry) minBytes.add(pair.getKey());

        }

        StringBuilder sb = new StringBuilder();
        for (Integer element : minBytes) {
            sb.append(element + " ");
        }
        System.out.print(sb.toString().trim());
    }
}
