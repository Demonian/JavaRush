package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        int fst = Integer.parseInt(reader.readLine());
        int snd = Integer.parseInt(reader.readLine());
        if (fst > snd){
            System.out.print(nod(fst,snd));
        }
        else{
            System.out.print(nod(snd,fst));
        }
    }

    public static int evklid(int bigger, int smaller){
        int result = 0;
        result = bigger - smaller;
        if (  result > smaller) return evklid(result,smaller);
        else return result;
    }


    public static int nod(int bigger, int smaller){
        int tmp = 0;
        while(true){
            tmp = evklid(bigger,smaller);
            if (tmp != 0) {
                bigger = smaller;
                smaller = tmp;
                tmp = evklid(bigger,smaller);
            }
            else return smaller;
        }
    }
}
