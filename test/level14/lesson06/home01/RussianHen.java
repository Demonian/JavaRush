package com.javarush.test.level14.lesson06.home01;

/**
 * Created by cyber on 25.05.14.
 */
public class RussianHen extends Hen{
    public int getCountOfEggsPerMonth(){
        return 30;
    }
    public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}