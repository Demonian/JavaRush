package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String tmp = reader.readLine();
            if (tmp.equals("exit") || tmp.equals("") || tmp == null || tmp.equals(null)) break;
            ReadThread thread = new ReadThread(tmp);
            thread.start();
            try{
                thread.join();
            } catch (InterruptedException e){
            }
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName){
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        public void run()
        {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            FileInputStream inputStream = null;
            try{
                try{
                    inputStream = new FileInputStream(fileName);
                } catch (FileNotFoundException ex){
                    return;
                }
            while (inputStream.available() > 0){
                int tmp = inputStream.read();
                if (map.containsKey(tmp)) map.put(tmp, map.get(tmp) + 1);
                else map.put(tmp, 1);
            }
            inputStream.close();
            } catch (IOException e){
            }

            int maxByte = Integer.MIN_VALUE;
            int maxValue = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                if (pair.getValue() > maxValue) {
                    maxValue = pair.getValue();
                    maxByte = pair.getKey();
                }
            }
            resultMap.put(fileName, maxByte);
        }

    }
}
