package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here - напиши код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String _str = str.toUpperCase();
        _str += " 5 1990";
        //System.out.println(_str);
        Date date = new Date(_str);
        int number = date.getMonth();
        number++;
        System.out.print(str + " is " + number + " month");

    }

}
