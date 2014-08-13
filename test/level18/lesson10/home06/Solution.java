package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception{
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        FileInputStream inputStream = new FileInputStream(args[0]);

        while(inputStream.available() > 0){
            int tmp = inputStream.read();
            if (map.containsKey(tmp)) map.put(tmp,map.get(tmp) + 1);
            else map.put(tmp,1);
        }
        int tmp = map.size();
        int min = Integer.MAX_VALUE;
        int[] codes = new int[tmp];
        int[] values = new int[tmp];

        for (int i = 0; i < tmp; i++){
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) if (pair.getKey() < min) min = pair.getKey();
            codes[i] = min;
            values[i] = map.remove(min);
            min = Integer.MAX_VALUE;
        }
        for ( int i = 0; i < tmp; i++){
            System.out.print(Character.toChars(codes[i])[0]+ " ");
            System.out.println(values[i]);
        }
        inputStream.close();
    }
}
