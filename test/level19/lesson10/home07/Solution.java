package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;

        try{
            BufferedReader fileReader = null;
            try{
                fileReader = new BufferedReader(new FileReader(args[0]));
            } catch (FileNotFoundException e){
            }

            String line = "";
            StringBuilder sb = new StringBuilder();
            FileWriter fileWriter = new FileWriter(args[1]);
            boolean flag = false;

            while ((line = fileReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (int i = 0; i < words.length; i++){
                    try{
                        Integer.parseInt(words[i]);
                    } catch (NumberFormatException e){
                        if (words[i].length() > 6) {
                            if (flag) fileWriter.write(",");
                            fileWriter.write(words[i]);
                            flag = true;
                        }
                    }
                }
            }
            fileReader.close();
            fileWriter.close();
        } catch (IOException e){
        }

    }
}
