package com.javarush.test.level15.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* Факториал
Написать метод, который вычисляет факториал - произведение всех чисел от 1 до введенного числа включая его.
Пример: 4! = factorial(4) = 1*2*3*4 = 24
1. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию  factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 1
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger input = BigInteger.valueOf(Integer.parseInt(reader.readLine()));
        reader.close();
        //BigInteger input = new BigInteger("151");
        System.out.println(factorial(input));
    }

    public static String factorial(BigInteger bigDigit) {
        //add your code here
        if (bigDigit.compareTo(BigInteger.valueOf(0)) < 0) return "0";
        if ((bigDigit.compareTo(BigInteger.valueOf(0)) == 0) || (bigDigit.compareTo(BigInteger.valueOf(1)) == 0)) return "1";
        bigDigit = bigDigit.multiply(new BigInteger(factorial(bigDigit.add(new BigInteger("-1")))));
        //bigDigit = bigDigit.multiply(bigDigit.valueOf(Integer.parseInt(factorial(bigDigit.intValue() - 1))));
        return bigDigit.toString();
    }
}
