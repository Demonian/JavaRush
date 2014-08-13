package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);

        String[] params = outputStream.toString().split(" ");
        int result = 0;
        if ("+".equals(params[1])) result = Integer.parseInt(params[0]) + Integer.parseInt(params[2]);
        if ("-".equals(params[1])) result = Integer.parseInt(params[0]) - Integer.parseInt(params[2]);
        if ("*".equals(params[1])) result = Integer.parseInt(params[0]) * Integer.parseInt(params[2]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < params.length - 1; i++) {
            sb.append(params[i]);
            sb.append(" ");
        }
        sb.insert(sb.length(), result);
        System.out.print(sb.toString().trim());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

