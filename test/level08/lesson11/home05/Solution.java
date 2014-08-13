package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Пример ввода:
мама     мыла раму.
Пример вывода:
Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //Напишите тут ваш код

        char[] str = new char[s.length()];
        //str = s.toCharArray();
        boolean space = true;
        for (int i = 0; i < str.length; i++){
            if (s.charAt(i) == ' ')  {
                str[i] = s.charAt(i);
                space = true;
            }
            else {
                if (space) str[i] = Character.toUpperCase(s.charAt(i));
                else str[i] = s.charAt(i);
                space = false;
            }
        }
    String _s = String.copyValueOf(str);
    System.out.print(_s);
    }


}
