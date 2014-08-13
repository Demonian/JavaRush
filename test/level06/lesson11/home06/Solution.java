package com.javarush.test.level06.lesson11.home06;

/* KissMyShinyMetalAss
Создай класс с именем KissMyShinyMetalAss. Создай объект этого класса, выведи его на экран.
*/
public class Solution
{
    public static void main(String[] args)
    {
        KissMyShinyMetalAss ass1 = new KissMyShinyMetalAss();
        System.out.println(ass1);
    }

    public static class KissMyShinyMetalAss
    {

    }

}
/*
public class Solution
{
    public static void main(String[] args)
    {
        KissMyShinyMetalAss ass1 = new KissMyShinyMetalAss("Bender Ass");
        System.out.println(ass1.ass_name);
    }

    public static class KissMyShinyMetalAss
    {
        String ass_name;

        public KissMyShinyMetalAss(String assIn){
            ass_name = assIn;
        }
    }

}*/
