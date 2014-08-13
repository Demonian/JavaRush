package com.javarush.test.level15.lesson12.home04;

/**
 * Created by San_Lex on 08.06.2014.
 */
public class Sun implements Planet
{
    private static Sun instance = new Sun();

    private Sun(){}

    public static Sun getInstance(){
        return instance;
    }


}
