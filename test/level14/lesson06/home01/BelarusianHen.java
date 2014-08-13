package com.javarush.test.level14.lesson06.home01;

/**
 * Created by cyber on 25.05.14.
 */
public class BelarusianHen extends Hen{
    public int getCountOfEggsPerMonth(){
        return 35;
    }
    public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
