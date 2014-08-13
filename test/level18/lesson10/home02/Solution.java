package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = new FileInputStream(args[0]);
        byte[] buffer = null;

        if (inputStream.available() > 0){
            buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);

            int spaceCount = 0;
            for (int letter : buffer) {
                if (letter == " ".codePointAt(0)) spaceCount++;
            }

            //System.out.print(  new BigDecimal( ((float)spaceCount/(float)count) * 100 ).setScale(2, RoundingMode.UP));
            System.out.print(String.format("%.2f",(float)(spaceCount*100)/count));
        }
        inputStream.close();
    }
}
