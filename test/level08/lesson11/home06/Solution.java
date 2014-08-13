package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human san = new Human();
        san.name = "Alex";
        san.age = 24;
        san.sex = true;
        san.children = new ArrayList();

        Human kost = new Human();
        kost.name = "Konstantin";
        kost.age = 9;
        kost.sex = true;
        kost.children =  new ArrayList();

        Human rost = new Human();
        rost.name = "Rostislav";
        rost.age = 9;
        rost.sex = true;
        rost.children =  new ArrayList();

        Human father = new Human();
        father.name = "Viktor";
        father.age = 48;
        father.sex = true;
        ArrayList<Human> fatherKids = new ArrayList<Human>();
        fatherKids.add(san);
        fatherKids.add(kost);
        fatherKids.add(rost);
        father.children = fatherKids;

        Human mother = new Human();
        mother.name = "Lidia";
        mother.age = 43;
        mother.sex = false;
        ArrayList<Human> motherKids = new ArrayList<Human>();
        motherKids.add(san);
        motherKids.add(kost);
        motherKids.add(rost);
        mother.children = motherKids;

        Human grandmother0 = new Human();
        grandmother0.name = "Shura";
        grandmother0.age = 83;
        grandmother0.sex = false;
        ArrayList<Human> grandmother0Kids = new ArrayList<Human>();
        grandmother0Kids.add(mother);
        grandmother0.children = grandmother0Kids;

        Human grandmother1 = new Human();
        grandmother1.name = "Vera";
        grandmother1.age = 82;
        grandmother1.sex = false;
        ArrayList<Human> grandmother1Kids = new ArrayList<Human>();
        grandmother1Kids.add(father);
        grandmother1.children = grandmother1Kids;

        Human grandpa0 = new Human();
        grandpa0.name = "Alexander";
        grandpa0.age = 85;
        grandpa0.sex = true;
        ArrayList<Human> grandpa0Kids = new ArrayList<Human>();
        grandpa0Kids.add(father);
        grandpa0.children = grandpa0Kids;

        Human grandpa1 = new Human();
        grandpa1.name = "Ivan";
        grandpa1.age = 84;
        grandpa1.sex = true;
        ArrayList<Human> grandpa1Kids = new ArrayList<Human>();
        grandpa1Kids.add(mother);
        grandpa1.children = grandpa1Kids;

        System.out.println(san);
        System.out.println(kost);
        System.out.println(rost);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(grandmother0);
        System.out.println(grandmother1);
        System.out.println(grandpa0);
        System.out.println(grandpa1);
;    }


    public static class Human
    {
        //Написать тут ваш код
        public String name;
        public boolean sex;
        public int age;
        ArrayList<Human> children;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
