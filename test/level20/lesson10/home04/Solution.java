package com.javarush.test.level20.lesson10.home04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Исправить ошибку
После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(
Исправить 1 ошибку.
Метод main в тестировании не участвует.
*/
public class Solution implements Serializable {
    private static final long serialVersionUID = 1L;

    public static void main(String args[]) throws Exception {
        Solution solution = new Solution();

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("d:/your.file.name"));
        outputStream.writeObject(solution);
        outputStream.close();

        ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream("d:/your.file.name"));
        Solution loadedObject = (Solution) objectStream.readObject();
        objectStream.close();

        System.out.println(solution.size());
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<String, String>();

    public Map<String, String> getMap() {
        return m;
    }

    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
