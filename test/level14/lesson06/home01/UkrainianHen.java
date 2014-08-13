package com.javarush.test.level14.lesson06.home01;

/**
 * Created by cyber on 25.05.14.
 */
public class UkrainianHen extends Hen{
    public int getCountOfEggsPerMonth(){
        return 32;
    }
    public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
