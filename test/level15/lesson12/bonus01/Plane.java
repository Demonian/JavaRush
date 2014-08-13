package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by San_Lex on 21.06.2014.
 */
public class Plane implements Flyable
{
    public int count = 0;
    public void fly(){};
    Plane (int count){
        this.count = count;
    }
}
