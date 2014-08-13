package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public static boolean isDateOdd(String date)
    {

        Date start = new Date();
        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);
        start.setDate(1);
        start.setMonth(0);

        Date current = new Date(date);
        if ((((current.getTime() - start.getTime())/(24 * 60 * 60 * 1000)) % 2) == 0) return false;
        else return true;
    }
}
