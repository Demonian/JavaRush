package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by San_Lex on 01.10.2014.
 */
public class Hippodrome
{
    public static ArrayList<Horse> horses = new ArrayList<>();

    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public Horse getWinner(){
        double result = Double.MIN_NORMAL;
        Horse winner = null;
        for (Horse horse : getHorses()) {
            if (horse.getDistance() > result) {
                result = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public void run(){
        for (int i = 1; i < 101; i++){
            move();
            print();
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
            }
        }
    }

    public void move(){
        for (Horse horse : getHorses()) horse.move();
    }

    public void print(){
        for (Horse horse : getHorses()) horse.print();
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args){
        game = new Hippodrome();
        Horse horse0 = new Horse("horse0", 3,0);
        Horse horse1 = new Horse("horse1", 3,0);
        Horse horse2 = new Horse("horse2", 3,0);
        game.getHorses().add(horse0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.run();
        game.printWinner();
    }
}
