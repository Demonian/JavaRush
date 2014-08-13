package com.javarush.test.level15.lesson12.home04;

/**
 * Created by San_Lex on 08.06.2014.
 */
public class Moon implements Planet
{
    private static Moon instance = new Moon();

    private Moon(){}

    public static Moon getInstance(){
        return instance;
    }

}
