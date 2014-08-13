package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        FileInputStream inputStream = new FileInputStream(fileName);

        while(inputStream.available() > 0){
            int tmp = inputStream.read();
            if (map.containsKey(tmp)) map.put(tmp,map.get(tmp) + 1);
            else map.put(tmp,1);
        }
        inputStream.close();

        List<Integer> maxBytes = new ArrayList<Integer>();
        int maxEntry = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() > maxEntry) {
                maxEntry = pair.getValue();
                maxBytes.clear();
                maxBytes.add(pair.getKey());
            }
            else if (pair.getValue() == maxEntry) maxBytes.add(pair.getKey());

        }

        StringBuilder sb = new StringBuilder();
        for (Integer element : maxBytes) {
            sb.append(element + " ");
        }
        System.out.print(sb.toString().trim());
    }
}
