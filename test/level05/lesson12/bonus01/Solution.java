package com.javarush.test.level05.lesson12.bonus01;

import java.io.*;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два числа с клавиатуры и выводит их сумму на экран.
*/

public class Solution
{
   public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        int _a = Integer.parseInt(a);
        String b = reader.readLine();
        int _b = Integer.parseInt(b);

        int sum = _a + _b;
        System.out.println("Sum = " + sum);
    }
}
