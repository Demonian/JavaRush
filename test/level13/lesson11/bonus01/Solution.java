package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));//fileName);
        List<Integer> list = new ArrayList<Integer>();
        String line = null;
        while( (line = fileReader.readLine()) != null )
        {
            list.add(Integer.parseInt(line));
        }

        List<Integer> evenList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++){
            if ( list.get(i) % 2 == 0) evenList.add((list.get(i)));
        }

        int[] array = new int[evenList.size()];
        for (int i = 0; i < evenList.size(); i++){
            array[i] = evenList.get(i);
        }
        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length-(i+1); j++){
                if (array[j] > array[j+1])
                {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
      for (Integer element : array){
            System.out.println(element);
        }
    }
}
