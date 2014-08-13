package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую половину.
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        FileInputStream inputStream1 = new FileInputStream(fileName1);
        FileOutputStream outputStream1= new FileOutputStream(fileName2);
        FileOutputStream outputStream2 = new FileOutputStream(fileName3);

        byte[] buffer = null;
        if(inputStream1.available() > 0){
            buffer = new byte[inputStream1.available()];
            int count = inputStream1.read(buffer);
            if (count%2 == 0){
                outputStream1.write(buffer,0,count/2);
                outputStream2.write(buffer,count/2,count/2);
            }
            else {
                outputStream1.write(buffer,0,count/2 + 1);
                outputStream2.write(buffer,count/2 + 1,count/2);
            }

        }
        inputStream1.close();
        outputStream1.close();
        outputStream2.close();

    }
}
