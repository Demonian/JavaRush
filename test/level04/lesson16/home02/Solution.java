package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String _m = reader.readLine();
        int m = Integer.parseInt(_m);
        String _n = reader.readLine();
        int n = Integer.parseInt(_n);
        String _k = reader.readLine();
        int k = Integer.parseInt(_k);
        if (m > n){
            if (m > k){
                if (n > k) System.out.print(n);
                else System.out.print(k);
            }
            else System.out.print(m);
        }
        else if (n > k) System.out.print(k);
             else System.out.print(n);
    }
}
