package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //Напишите тут ваш код
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(45);
        set.add(4);
        set.add(-5);
        set.add(0);
        set.add(33);
        set.add(91);
        set.add(34);
        set.add(6);
        set.add(113);
        set.add(81);
        set.add(-99);
        set.add(2);
        set.add(11);
        set.add(44);
        set.add(-19);
        set.add(13);
        set.add(67);
        set.add(49);
        set.add(-42);
        set.add(-96);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThen10(HashSet<Integer> set)
    {
        //Напишите тут ваш код
       Iterator<Integer> iterator = set.iterator();
       while(iterator.hasNext()){
           int tmp = iterator.next();
           if (tmp > 10) iterator.remove();
       }
    return set;
    }
}
