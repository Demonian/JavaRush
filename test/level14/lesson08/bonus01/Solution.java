package com.javarush.test.level14.lesson08.bonus01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            int[] array = new int[1];
            array[5] = 6;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            class A {}
            class B extends A {}
            B[] x1 = new B[10];
            A[] x2 = x1;

            x2[0] = new A();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            InputStream reader = new FileInputStream("d:/qweasd");
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Object i = Integer.valueOf(42);
            String s = (String) i;
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Class.forName("asdqwe");
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int[] array = null;
            int i = array.length;
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            String s = "";
            int i = s.charAt(15);
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            String siteUrl = "asdasdasd";
            URL url;
            url = new URL(siteUrl);
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new IllegalMonitorStateException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
