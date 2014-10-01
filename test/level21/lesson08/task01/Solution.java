package com.javarush.test.level21.lesson08.task01;

import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException{
        Solution solution = new Solution();
        for (Map.Entry<String, User> pair : users.entrySet()) solution.users.put(new String(pair.getKey()),pair.getValue().clone());
        return solution;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User {
        int age;
        String name;

        @Override
        protected User clone() throws CloneNotSupportedException{
            return new User(this.age, this.name);
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
