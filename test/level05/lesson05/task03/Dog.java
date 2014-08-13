package com.javarush.test.level05.lesson05.task03;

/* Геттеры и сеттеры для класса Dog
Создать class Dog. У собаки должна быть кличка String name и возраст int age.
Создайте геттеры и сеттеры для всех переменных класса Dog.
*/
public class Dog {
    //добавьте переменные класса тут
    private String name;
    private int age;
    //добавьте геттеры и сеттеры тут
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
   /* public static void main(String[] args)
    {
    Dog sharik = new Dog();
    sharik.SetName("some_name");
    sharik.SetAge(500);
    System.out.println(sharik.GetName());
    System.out.println(sharik.GetAge());
    }*/
}

