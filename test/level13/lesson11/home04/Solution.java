package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        OutputStream outStream = new FileOutputStream(fileName);
        while(true){
            String line = reader.readLine();

            char[] chars = new char[line.length()];
            chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++){
                outStream.write((int)chars[i]);
            }
            outStream.write(13);
            outStream.write(10);
            if (line.equals("exit")) break;
        }
    }
}
