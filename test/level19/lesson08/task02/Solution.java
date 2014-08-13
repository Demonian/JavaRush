package com.javarush.test.level19.lesson08.task02;

/* Ридер обертка 2
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна заменять все подстроки "te" на "??"
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
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
        byte[] bytes = outputStream.toByteArray();
        System.setOut(consoleStream);

        for (int i = 0; i < bytes.length - 1; i++) {
            if (bytes[i] == 116 && bytes[i + 1] == 101) {
                bytes[i] = 63;
                bytes[i + 1] = 63;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (byte element : bytes) sb.append(Character.toChars(element));

        System.out.println(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
    }
    }
}
