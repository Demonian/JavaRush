package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
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
            while ((line = fileReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    try{
                        Integer.parseInt(word);
                    } catch (NumberFormatException e){
                        for (int i = 0; i < word.length(); i++){
                            if (word.codePointAt(i) > 47 && word.codePointAt(i) < 58) {
                                sb.append(word);
                                sb.append(" ");
                                break;
                            }
                        }
                    }
                }
            }
            fileReader.close();

            FileWriter fileWriter = new FileWriter(args[1]);
            fileWriter.write(sb.toString().trim());
            fileWriter.close();

        } catch (IOException e){
        }
    }
}
