package com.javarush.test.level21.lesson08.task02;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant {
        private String[] branches;

        @Override
        protected Tree clone() throws CloneNotSupportedException{
            if (this.branches != null ){
                String newBranches[] = new String[this.getBranches().length];
                for (int i = 0; i < newBranches.length; i++) newBranches[i] = this.getBranches()[i];
                if (super.getName() != null) return new Tree(new String(super.getName()),newBranches);
                else return new Tree(null,newBranches);
            }
            if (super.getName() != null) return new Tree(new String(super.getName()),null);
            return new Tree(null, null);
        }

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }
    }
}
