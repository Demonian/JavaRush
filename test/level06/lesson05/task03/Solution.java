package com.javarush.test.level06.lesson05.task03;

/* 10 000 объектов Cat и Dog
Создать в цикле 10 000 объектов Cat и Dog. (Java-машина должна начать уничтожать неиспользуемые, и метод finalize хоть раз да вызовется).
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Напишите тут ваш код
        Cat[] arr1 = new Cat[1000000];
        Dog[] arr2 = new Dog[1000000];
        for(int i = 0; i<1000000; i++){
            arr1[i] = new Cat();
            arr2[i] = new Dog();
        }
       //int test = 123;
      // System.out.print(test);
    }

}
class Cat
{
    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
        System.out.println("Cat destroyed");
    }
}

class Dog
{
    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
        System.out.println("Dog destroyed");
    }
}