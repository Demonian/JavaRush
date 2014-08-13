package com.javarush.test.level15.lesson12.home05;

/**
 * Created by cyber on 09.06.14.
 */
public class SubSolution extends Solution
{
    public SubSolution(short i)
    {
        super(i);
    }

    public SubSolution(int i)
    {
        super(i);
    }

    public SubSolution(long i)
    {
        super(i);
    }

    protected SubSolution(char c)
    {
        super(c);
    }

    protected SubSolution(String c)
    {
        super(c);
    }

    protected SubSolution(char c, char cc)
    {
        super(c, cc);
    }

    SubSolution()
    {
    }

    SubSolution(Object o)
    {
        super(o);
    }

    SubSolution(Exception e)
    {
        super(e);
    }

    private SubSolution(float d){}
    private SubSolution(double d){}
    private SubSolution(double d,double dd){}
}
