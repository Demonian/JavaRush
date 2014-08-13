package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<String>();

        while(true){
            String tmp = reader.readLine();
            if (tmp.equals("exit")) break;
            lines.add(tmp);
         }

        for(String element : lines )
        {
            int intDigit = 0;
            double doubleDigit = 0.0;
            try
            {
                intDigit = Integer.parseInt(element);
                if (intDigit > 0 && intDigit < 128) print((short) intDigit);
                else print(intDigit);
            }
            catch (NumberFormatException e0)
            {
                try
                {
                    doubleDigit = Double.parseDouble(element);
                    print(doubleDigit);
                }
                catch (NumberFormatException e1)
                {
                    print(element);
                }
            }
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
