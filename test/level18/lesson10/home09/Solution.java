package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = null;
        String name = "";

        while (true){
            try{
                try{
                    name = reader.readLine();
                } catch (IOException e){
                }
                inputStream = new FileInputStream(name);
            } catch (FileNotFoundException e){
                System.out.print(name);
                break;
            }
            try
            {
                inputStream.close();
            } catch (IOException ex) {

            }
        }
        try{
            reader.close();
        } catch (IOException e){
        }
    }
}
