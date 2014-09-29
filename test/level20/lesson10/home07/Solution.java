package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {
    private static final long serialVersionUID = 1L;
    transient private FileOutputStream stream;
    private String fileName;
    private String data = "";

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }


    public static void main(String[] args) throws Exception{
        Solution solution = new Solution("d:/test.txt");
        solution.writeObject("start string");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/data.dat"));
        oos.writeObject(solution);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/data.dat"));
        Solution loaded = (Solution) ois.readObject();
        ois.close();
        loaded.writeObject("end string");
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
        data += string + "\n";
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName);
        stream.write(data.getBytes());
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
