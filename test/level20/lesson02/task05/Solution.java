package com.javarush.test.level20.lesson02.task05;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* И еще раз о синхронизации
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(java.lang.String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            //OutputStream outputStream = new FileOutputStream("d:/1.txt");
            InputStream inputStream = new FileInputStream("d:/1.txt");

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            //object.save(outputStream);
            //outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4

            if (loadedObject.string1 != null) loadedObject.string1.print();
            else System.out.println("string 1 is null");
            if (loadedObject.string2 != null) loadedObject.string2.print();
            else System.out.println("string 2 is null");
            //System.out.println("---read---");
            loadedObject.load(inputStream);
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны
            if (object.string1 != null) object.string1.print();
            else System.out.println("string 1 is null");
            if (object.string2 != null) object.string2.print();
            else System.out.println("string 2 is null");
            if (loadedObject.string1 != null) loadedObject.string1.print();
            else System.out.println("string 1 is null");
            if (loadedObject.string2 != null) loadedObject.string2.print();
            else System.out.println("string 2 is null");

            //outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream,true);
            PrintStream consoleStream = System.out;
            ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
            PrintStream stream = new PrintStream(outputStream1);
            System.setOut(stream);

            if (this.string1 == null) printWriter.println("string1 string #" + 0);
            else {
                this.string1.print();
                printWriter.print("string1 " + outputStream1.toString());
            }
            outputStream1.reset();
            if (this.string2 == null) printWriter.println("string2 string #" + 0);
            else {
                this.string2.print();
                printWriter.print("string2 " + outputStream1.toString());
            }
            printWriter.close();
            System.setOut(consoleStream);
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Map<java.lang.String,Integer> lines = new HashMap<java.lang.String, Integer>();
            java.lang.String line = "";
            int tmpCount = countStrings;

            while (reader.ready()) {
                line = reader.readLine();
                java.lang.String[] tmp = line.split(" ");
                if (tmp.length != 3) ;
                else if ("string1".equals(tmp[0]) || "string2".equals(tmp[0])){
                    if ("string".equals(tmp[1]) && tmp[2].charAt(0) == '#'){
                        java.lang.String strNumber = tmp[2].substring(1,tmp[2].length());
                        try
                        {
                            int numToWrite = Integer.parseInt(strNumber);
                            lines.put(tmp[0], numToWrite);
                        } catch (NumberFormatException e){
                        }
                    }
                }
            }
            reader.close();
            if (lines.size() > 0){
                int number = 0;
                if (lines.get("string1") != null) number = lines.get("string1") - 1;
                if (number > -1)
                {
                    countStrings = number;
                    this.string1 = new String();
                    countStrings = tmpCount;
                } else this.string1 = null;

                if (lines.get("string2") != null) number = lines.get("string2") - 1;
                if (number > -1)
                {
                    countStrings = number;
                    this.string2 = new String();
                    countStrings = tmpCount;
                } else this.string2 = null;
            }
        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }

    }
}