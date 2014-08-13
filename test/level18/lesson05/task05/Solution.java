package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть все потоки ввода-вывода
2.2 выбросить исключение DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = null;
        while(true){
            try
            {
                inputStream = new FileInputStream(reader.readLine());
                if (inputStream.available() < 1000) {
                    inputStream.close();
                    reader.close();
                    throw new DownloadException();
                }
            } catch (IOException e) {
            }
        }
    }

    public static class DownloadException extends Exception{

    }
}
