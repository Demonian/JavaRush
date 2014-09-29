package com.javarush.test.level20.lesson10.home02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable{
    private static final long serialVersionUID = 1L;
    public A getOriginalObject(ObjectInputStream objectStream) {
        Object o = null;
        try{
           o = objectStream.readObject();
        } catch (IOException ioe){
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        if (o instanceof B) return (B)o;
        else return (A)o;
    }

    public class A implements Serializable{
        private static final long serialVersionUID = 1L;
    }

    public class B extends A {
        private static final long serialVersionUID = 1L;
        public B() {
            System.out.println("inside B");
        }
    }
}
