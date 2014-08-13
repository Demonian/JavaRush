package com.javarush.test.level16.lesson13.home10;

import java.io.*;

/* Последовательный вывод файлов
1. Разберись, что делает программа.
2. В статическом блоке считай 2 имени файла firstFileName и secondFileName.
3. Внутри класса Solution создай нить public static ReadFileThread, которая реализует
интерфейс ReadFileInterface (Подумай, что больше подходит - Thread или Runnable).
3.1. Метод setFileName должен устанавливать имя файла, из которого будет читаться содержимое.
3.2. Метод getFileContent должен возвращать содержимое файла.
3.3. В методе run считай содержимое файла, закрой поток. Раздели пробелом строки файла.
4. Подумай, в каком месте нужно подождать окончания работы нити, чтобы обеспечить последовательный вывод файлов.
4.1. Для этого добавь вызов соответствующего метода.
Ожидаемый вывод:
[все тело первого файла]
[все тело второго файла]
*/

public class Solution {
    public static String firstFileName;// = "d:/1.txt";
    public static String secondFileName;// = "d:/2.txt";

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        firstFileName = reader.readLine();
        secondFileName = reader.readLine();
        reader.close();
        }
        catch (IOException e) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fileName;
        private String result = "";
        private String tmp = "";
        public void setFileName(String fullFileName){
            this.fileName = fullFileName;
        }
        public String getFileContent(){
            return this.result;
        }

        public void run(){
            try{
                BufferedReader fileReader = new BufferedReader(new FileReader(this.fileName));
                while( (this.tmp = fileReader.readLine()) != null ){
                    this.result += this.tmp + " ";
                }
                this.result.trim();
                fileReader.close();
            }
            catch (IOException e){
            }
        }
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public static interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }
}
