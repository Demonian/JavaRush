package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        public String name;
        public String surname;
        public int age;
        public boolean sex;
        public int weight;
        public int height;

    Human(String name, boolean sex){
        this.name = name;
        this.surname = "no surname";
        this.age = 0;
        this.sex = sex;
        this.weight = 0;
        this.height = 0;
    }

    Human(String name, String surname, boolean sex){
        this.name = name;
        this.surname = surname;
        this.age = 0;
        this.sex = sex;
        this.weight = 0;
        this.height = 0;
    }
        Human(String name, String surname, int age, boolean sex){
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.sex = sex;
            this.weight = 0;
            this.height = 0;
        }

        Human(String name, String surname, int age, int weight, boolean sex){
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.height = 0;
        }
        Human(String name, String surname, int age, int weight, int height, boolean sex){
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
        }
        Human(String name, int age, int weight, int height, boolean sex){
            this.name = name;
            this.surname = "no surname";
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
        }

        Human(String name, int age, int weight, boolean sex){
            this.name = name;
            this.surname = "no surname";
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.height = 0;
        }

        Human(){
            this.name = "no name";
            this.surname = "no surname";
            this.age = 0;
            this.sex = false;
            this.weight = 0;
            this.height = 0;
        }

        Human(String surname)
        {
            this.name = "no name";
            this.surname = surname;
            this.age = 0;
            this.sex = false;
            this.weight = 0;
            this.height = 0;
        }
        Human(boolean sex)
        {
            this.name = "no name";
            this.surname = "na surname";
            this.age = 0;
            this.sex = sex;
            this.weight = 0;
            this.height = 0;
        }
    }
}
