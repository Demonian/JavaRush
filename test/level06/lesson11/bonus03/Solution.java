package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        //Напишите тут ваш код
        int[] arr = new int[5];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = Integer.parseInt(reader.readLine());
        }

        int tmp;
        for(int j = 0; j < arr.length-1; j++){
            for(int i = 0; i < arr.length-(j+1); i++){
                if(arr[i] > arr[i+1]){
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
        for(int i = 0 ; i < 5; i++){
            System.out.println(arr[i]);
        }
    }
}
