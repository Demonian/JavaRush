package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(int i=0;i<32;i++)
        {
            alphabet.add( (char) ('а'+i));
        }
        alphabet.add(6,'ё');

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<10;i++)
        {
            String s = reader.readLine();
            list.add( s.toLowerCase());
        }


        //Напишите тут ваш код
        /*HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char element : alphabet ){
            map.put(element,0);
        }
        for (int i = 0; i < list.size(); i++){
            char[] chars = new char[list.get(i).length()];
            chars = list.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++){
                for (Map.Entry<Character, Integer> pair : map.entrySet()){
                    if (chars[j] == pair.getKey()) pair.setValue(pair.getValue()+1);
                }
            }
        }
        for (Map.Entry<Character, Integer> pair : map.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }*/
        int[] result = new int[33];
        for (int i = 0; i < list.size(); i++){
            char[] chars = new char[list.get(i).length()];
            chars = list.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++){
                for (int k = 0; k < alphabet.size(); k++){
                    if (chars[j] == alphabet.get(k)) {
                        result[k]++;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < alphabet.size(); i++){
            System.out.println(alphabet.get(i) + " " + result[i]);
        }


    }

}
