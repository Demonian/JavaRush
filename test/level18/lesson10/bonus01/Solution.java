package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        if (args[0].charAt(1) == 'e' ) {
            try
            {
                FileInputStream inputStream = new FileInputStream(args[1]);
                byte[] buffer = null;
                if (inputStream.available() > 0) {
                    buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                }
                inputStream.close();

                byte[] eBuffer = new byte[buffer.length];
                for (int i = 0; i < eBuffer.length; i++) eBuffer[i] = (byte)(buffer[i] + 127);
                FileOutputStream outputStream = new FileOutputStream(args[2]);
                outputStream.write(eBuffer);
                outputStream.close();
            } catch (FileNotFoundException e) {
            }
        }

        if (args[0].charAt(1) == 'd' ) {
            try
            {
                FileInputStream inputStream2 = new FileInputStream(args[1]);
                byte[] buffer2 = null;
                if (inputStream2.available() > 0) {
                    buffer2 = new byte[inputStream2.available()];
                    inputStream2.read(buffer2);
                }
                inputStream2.close();

                byte[] eBuffer2 = new byte[buffer2.length];
                for (int i = 0; i < eBuffer2.length; i++) eBuffer2[i] = (byte)(buffer2[i] - 127);
                FileOutputStream outputStream2 = new FileOutputStream(args[2]);
                outputStream2.write(eBuffer2);
                outputStream2.close();
            } catch (FileNotFoundException e) {
            }
        }
    }
}
