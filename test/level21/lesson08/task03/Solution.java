package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Запретите клонировать класс B
Разрешите клонировать класс C
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        @Override
        protected  A clone() throws CloneNotSupportedException{
            return (A) super.clone();
        }

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        @Override
        protected B clone() throws CloneNotSupportedException{
            throw new CloneNotSupportedException();
        }

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    public static class C extends B {
        @Override
        protected C clone() throws CloneNotSupportedException{
            return new C(super.getI(), super.getJ(),super.getName());
        }

        public C(int i, int j, String name) {
            super(i, j, name);
        }
    }



    public static void main(String[] args){
        A a = new A(1,2);
        B b = new B(3,4,"some shit");
        C c = new C(5,6,"somest shit");
        B bb = null;
        try{
            bb = (B) b.clone();
        } catch (Exception e){
            //e.printStackTrace();
        }
        A aa = null;
        try{
            aa = (A) a.clone();
        } catch (Exception e){
            //e.printStackTrace();
        }
        C cc = null;
        try{
            cc = (C) c.clone();
        } catch (Exception e){
           //e.printStackTrace();
        }
            System.out.println("A:      " + a.getI() + " " + a.getJ() + " " + a);
            System.out.println("CloneA: " + aa.getI() + " " + aa.getJ() + " " + aa);
            System.out.println("B:      " + b.getI() + " " + b.getJ() + " " + b.getName() + " " + b);
            System.out.println("CloneB: " + bb);//+ bb.getI() + " " + bb.getJ() + " " + bb.getName());
            System.out.println("C:      " + c.getI() + " " + c.getJ() + " " + c.getName() + " " + c);
            System.out.println("CloneC: " + cc.getI() + " " + cc.getJ() + " " + cc.getName() + " " + cc);

    }
}
