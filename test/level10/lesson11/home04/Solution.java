package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //Напишите тут ваш код
        char[] chars = new char[s.length()];
        chars = s.toCharArray();
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < chars.length; i++){
            list.add(chars[i]);
        }

        for (int i = 0; i < 40;i++){
            for(int j = 0; j < list.size(); j++){
                System.out.print(list.get(j));
            }
            System.out.println();
            list.remove(0);
        }
    }

}
