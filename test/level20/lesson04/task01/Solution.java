package com.javarush.test.level20.lesson04.task01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Как сериализовать?
Сделайте так, чтобы сериализация класса Human была возможной
*/
public class Solution {
    public Solution(){}

    public static class Human implements Serializable{
        private static final long serialVersionUID = 1L;
        public String name;
        public List<Asset> assets = new ArrayList<Asset>();

        public Human() {}

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }
}
