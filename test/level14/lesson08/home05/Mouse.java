package com.javarush.test.level14.lesson08.home05;

/**
 * Created by cyber on 25.05.14.
 */
public class Mouse implements CompItem
{
    public String getName(){
        return this.getClass().getSimpleName();
    }
}
