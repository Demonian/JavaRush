package com.javarush.test.level16.lesson03.task01;

/* My first thread
Создать public static class TestThread - нить с помощью интерфейса Runnable.
TestThread должен выводить в консоль "My first thread".
*/
public class Solution {
    public static void main(String[] args) {

        TestThread task = new TestThread();
        new Thread(task).start();
    }
    static class TestThread implements Runnable {
        /*private String name;
        public TestThread(String name){
            this.name = name;
        }*/
        public void run(){
            System.out.println("My first thread");
        }
    }
}
