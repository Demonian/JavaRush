package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.
*/

import java.util.ArrayList;
import java.util.Iterator;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static String method1()
    {
        method2();
        //Напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        ArrayList<String> list = new ArrayList<String>();
        for(StackTraceElement element : stackTraceElements){
            list.add(element.getMethodName());
        }
        String result = list.get(2);
        System.out.println(result);
        return result;

    }

    public static String method2()
    {
        method3();
        //Напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        ArrayList<String> list = new ArrayList<String>();
        for(StackTraceElement element : stackTraceElements){
            list.add(element.getMethodName());
        }
        String result = list.get(2);
        System.out.println(result);
        return result;

    }

    public static String method3()
    {
        method4();
        //Напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        ArrayList<String> list = new ArrayList<String>();
        for(StackTraceElement element : stackTraceElements){
            list.add(element.getMethodName());
        }
        String result = list.get(2);
        System.out.println(result);
        return result;

    }

    public static String method4()
    {
        method5();
        //Напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        ArrayList<String> list = new ArrayList<String>();
        for(StackTraceElement element : stackTraceElements){
            list.add(element.getMethodName());
        }
        String result = list.get(2);
        System.out.println(result);
        return result;

    }

    public static String method5()
    {
        //Напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        ArrayList<String> list = new ArrayList<String>();
        for(StackTraceElement element : stackTraceElements){
            list.add(element.getMethodName());
        }
        String result = list.get(2);
        System.out.println(result);
        return result;

    }
}
