package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by cyber on 27.05.14.
 */
public class Singleton
{
    private Singleton(){
    }

    public static Singleton singleton;
    public static Singleton getInstance(){
        return singleton;
    }
}
