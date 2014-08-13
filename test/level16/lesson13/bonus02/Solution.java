package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static{
        threads.add(new Infinity());
        threads.add(new IntExep());
        threads.add(new Ura());
        threads.add(new Mess());
        threads.add(new Rd());
    }



    public static class Infinity extends Thread{
        public void run(){
            while(true){
            }
        }
    }

    public static class IntExep extends Thread{
        public void run(){
            while(true)
            {
                try
                {
                    Thread.sleep(1);
                }
                catch (InterruptedException e)
                {
                    System.out.println("InterruptedException");
                    return;
                }
            }
        }
    }

    public static class Ura extends Thread{
        public void run(){
            while(true)
            {
                try
                {
                    Thread.sleep(500);
                    System.out.println("Ура");
                }
                catch (InterruptedException e)
                {

                }
            }
        }
    }

    public static class Mess extends Thread implements Message{

        public void showWarning(){
            try{
                interrupt();
                join();
            }catch (InterruptedException e) {
            }
        }
        public void run(){
            while(!isInterrupted()){
            }
        }
    }

    public static class Rd extends Thread{
        public void run(){
            String tmp = "";
            List<Integer> list = new ArrayList<Integer>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                try{
                    tmp = reader.readLine();
                }
                catch (IOException e) {
                }
                if (tmp.equals("N"))  {
                    int result = 0;
                    if (list.size() == 0) {
                        System.out.print(0);
                        return;
                    }
                    for (int i = 0; i < list.size(); i++) result += list.get(i);
                    System.out.print(result);
                    return;
                }
                list.add(Integer.parseInt(tmp));
            }
        }
    }
}
