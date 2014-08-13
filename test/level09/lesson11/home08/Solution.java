package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Random;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //Написать тут ваш код
        int[] array1 = new int[5];
        int[] array2 = new int[2];
        int[] array3 = new int[4];
        int[] array4 = new int[7];
        int[] array5 = new int[0];
        ArrayList<int[]> list = new ArrayList<int[]>();

        Random random = new Random(100);

        list.add(array1);
        list.add(array2);
        list.add(array3);
        list.add(array4);
        list.add(array5);

        for (int i = 0; i < list.size(); i++)
         {
            System.out.println("Length " + list.get(i).length);
             for (int j = 0; j < list.get(i).length; j++)
            {
                list.get(i)[j] = random.nextInt(100);
                System.out.println("list(" + i + ")[" + j + "] = " + list.get(i)[j]);
            }
         }
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
