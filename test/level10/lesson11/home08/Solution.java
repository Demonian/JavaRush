package com.javarush.test.level10.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести на их экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //Напишите тут ваш код
        ArrayList<String>[] list = new ArrayList[3];
        list[0] = new ArrayList<String>();
        list[0].add("string1.1");
        list[0].add("string2.1");
        list[0].add("string3.1");
        list[1] = new ArrayList<String>();
        list[1].add("string1.2");
        list[1].add("string2.2");
        list[1].add("string3.2");
        list[2] = new ArrayList<String>();
        list[2].add("string1.3");
        list[2].add("string2.3");
        list[2].add("string3.3");
        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}