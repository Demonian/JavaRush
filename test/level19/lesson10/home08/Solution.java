package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        String line = null;
        StringBuilder sb = new StringBuilder();

        try{
            fileName = reader.readLine();
            reader.close();
            BufferedReader fileReader = null;
            try{
                fileReader = new BufferedReader(new FileReader(fileName));
                while ((line = fileReader.readLine()) != null) {
                    sb.append(line);
                    sb = sb.reverse();
                    sb.append("\n\r");
                    System.out.print(sb.toString());
                    sb = new StringBuilder();
                }
                fileReader.close();
            } catch (FileNotFoundException e){
            }

        } catch (IOException e){
        }
    }
}
