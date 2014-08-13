package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину её стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем (количество элементов в списке). Это же число метод должен выводить на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args){
       getStackTraceDeep();
    }
    public static int getStackTraceDeep()
    {
        //Напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        ArrayList<String> list = new ArrayList<String>();
        for(StackTraceElement element : stackTraceElements){
            list.add(element.getMethodName());
        }
        /*for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }*/
        System.out.println(list.size());
        return list.size();
     }
}
