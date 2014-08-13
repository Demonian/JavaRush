package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human grandpa1 = new Human();
        grandpa1.name = "Ivan";
        grandpa1.sex = true;
        grandpa1.age = 82;
        grandpa1.father = null;
        grandpa1.mother = null;

        Human grandpa2 = new Human();
        grandpa2.name = "Aleksandr";
        grandpa2.sex = true;
        grandpa2.age = 83;
        grandpa2.father = null;
        grandpa2.mother = null;

        Human grandma1 = new Human();
        grandma1.name = "Shura";
        grandma1.sex = false;
        grandma1.age = 79;
        grandma1.father = null;
        grandma1.mother = null;

        Human grandma2 = new Human();
        grandma2.name = "Vera";
        grandma2.sex = false;
        grandma2.age = 80;
        grandma2.father = null;
        grandma2.mother = null;

        Human father = new Human();
        father.name = "Viktor";
        father.sex = true;
        father.age = 47;
        father.father = grandpa2;
        father.mother = grandma2;


        Human mother = new Human();
        mother.name = "Lidia";
        mother.sex = false;
        mother.age = 42;
        mother.father = grandpa1;
        mother.mother = grandma1;

        Human san = new Human();
        san.name = "Alex";
        san.sex = true;
        san.age = 24;
        san.father = father;
        san.mother = mother;

        Human kost = new Human();
        kost.name = "Konstantin";
        kost.sex = true;
        kost.age = 9;
        kost.father = father;
        kost.mother = mother;

        Human rost = new Human();
        rost.name = "Rostislav";
        rost.sex = true;
        rost.age = 9;
        rost.father = father;
        rost.mother = mother;

        System.out.println(grandpa1);
        System.out.println(grandma1);
        System.out.println(grandpa2);
        System.out.println(grandma2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(san);
        System.out.println(kost);
        System.out.println(rost);
    }

    public static class Human
    {
        //Написать тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
