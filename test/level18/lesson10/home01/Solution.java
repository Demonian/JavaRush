package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        String alphabet = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        int[] intAlphabet = new int[alphabet.length()];
        for (int i = 0; i < alphabet.length(); i++) {
            intAlphabet[i] = alphabet.codePointAt(i);
        }

        FileInputStream inputStream = new FileInputStream(args[0]);
        byte[] buffer = null;

        if (inputStream.available() > 0){
            buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
        }

        int count = 0;
        for (int element : buffer)
        {
            for (int codeLetter : intAlphabet)
            {
                if (element == codeLetter) count++;
            }
        }
        System.out.print(count);
        inputStream.close();
    }
}
