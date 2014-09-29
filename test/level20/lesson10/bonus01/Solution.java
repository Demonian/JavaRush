package com.javarush.test.level20.lesson10.bonus01;

import java.lang.Math;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 1;i < N + 1;i++){
            int power = (i + "").length();
            int sum = 0;int digit = 0;int tmp = i;
            while (tmp > 0) {
                digit = tmp % 10;
                tmp /= 10;
                int pow = digit;
                for (int j = 1; j < power; j++) pow = pow * digit;
                sum += pow;
            }
            if (sum == i) list.add(sum);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) result[i] = list.get(i);
        return result;
    }

}
