package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int digit,summ = 0;
        //boolean isExit;
        while (true){
            line = reader.readLine();
            if (line.equals("сумма")) {
                System.out.print(summ);
                return;
            }
            else {
                digit = Integer.parseInt(line);
                summ += digit;
            }
        }
    }
}
