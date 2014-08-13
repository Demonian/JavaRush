package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution(short i){}
    public Solution(int i){}
    public Solution(long i){}

    private Solution(float d){}
    private Solution(double d){}
    private Solution(double d,double dd){}

    protected Solution(char c){}
    protected Solution(String c){}
    protected Solution(char c, char cc){}

    Solution(){}
    Solution(Object o){}
    Solution(Exception e){}
}

