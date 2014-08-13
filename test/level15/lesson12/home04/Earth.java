package com.javarush.test.level15.lesson12.home04;

/**
 * Created by San_Lex on 08.06.2014.
 */
public class Earth implements Planet
{
    private static Earth instance = new Earth();

    private Earth(){}

    public static Earth getInstance(){
        return instance;
    }
}
