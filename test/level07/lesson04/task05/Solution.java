package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        int[] array = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i <  array.length; i++){
            array[i] = Integer.parseInt(reader.readLine());
        }
        int[] mini_arr1 = new int[10];
        int[] mini_arr2 = new int[10];
        for(int i = 0; i < array.length; i++){
            if(i < 10) mini_arr1[i] = array[i];
            else mini_arr2[-10+i] = array[i];
        }
    for(int i = 0; i < mini_arr2.length; i++){
        System.out.println(mini_arr2[i]);
    }
    }
}
