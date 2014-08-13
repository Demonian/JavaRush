package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        //String line = "http://javarush.ru/alpha/index.html?obj=yoyo&name=Amigo&param&koko";
        String[] parameters = line.split("\\?");

        if (parameters.length < 2) {
            return;
        }

        parameters = parameters[1].split( "&" );
        for (String s : parameters){
            System.out.print( s.split( "=" )[0] + " ");
        }
        System.out.println();

        for (String s : parameters)
        {
            String[] nextParameter = s.split( "=" );
            if ("obj".equals(nextParameter[0])){
                try{
                    alert(Double.parseDouble(nextParameter[1]));
                }catch (NumberFormatException e){
                    alert(nextParameter[1]);
                }
            }

        }

        /*System.out.println();
        for (String element : parameters)
        {
            System.out.print(element + " ");
        }
        //found index and coping into new string
        /*int lineIndex = 0;
        lineIndex = line.indexOf(63) + 1;
        char[] chars = new char[line.length() - lineIndex];
        for (int i = lineIndex, j = 0; i < line.length(); i++, j++) {
            chars[j] = line.charAt(i);
        }
        //System.out.println(chars);

        //split to parameters and values
        List<Character> paramBuffer = new ArrayList<Character>();
        List<Character> valueBuffer = new ArrayList<Character>();
        boolean paramCheck = true;
        boolean valueCheck = false;
        Map<String, String> pairs = new HashMap<String, String>();
        String paramTmp = "";
        String valueTmp = "";

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '=' || ( i == (chars.length - 1))) {
                if ( i == (chars.length - 1) && (chars[i] != '=')) {
                    if (paramCheck) paramBuffer.add(chars[i]);
                    if (valueCheck) valueBuffer.add(chars[i]);
                    char[] tmp0 = new char[paramBuffer.size()];
                    for(int j = 0; j < tmp0.length; j++){
                        tmp0[j] = paramBuffer.get(0);
                        paramBuffer.remove(0);
                    }
                    paramTmp = String.copyValueOf(tmp0);

                    if ( valueBuffer.size() > 0)
                    {
                        char[] tmp1 = new char[valueBuffer.size()];
                        for (int j = 0; j < tmp1.length; j++)
                        {
                            tmp1[j] = valueBuffer.get(0);
                            valueBuffer.remove(0);
                        }
                        valueTmp = String.copyValueOf(tmp1);
                    }
                    pairs.put(paramTmp, valueTmp);
                    paramTmp = "";
                    valueTmp = "";
                }
                paramCheck = false;
                valueCheck = true;
                continue;
            }
            if (chars[i] == '&' || ( i == (chars.length - 1))) {
                if ( i == (chars.length - 1) && (chars[i] != '=')) {
                    valueBuffer.add(chars[i]);
                }
                paramCheck = true;
                valueCheck = false;
                char[] tmp0 = new char[paramBuffer.size()];
                for(int j = 0; j < tmp0.length; j++){
                    tmp0[j] = paramBuffer.get(0);
                    paramBuffer.remove(0);
                }
                paramTmp = String.copyValueOf(tmp0);

                if ( valueBuffer.size() > 0)
                {
                    char[] tmp1 = new char[valueBuffer.size()];
                    for (int j = 0; j < tmp1.length; j++)
                    {
                        tmp1[j] = valueBuffer.get(0);
                        valueBuffer.remove(0);
                    }
                    valueTmp = String.copyValueOf(tmp1);
                }
                pairs.put(paramTmp, valueTmp);
                paramTmp = "";
                valueTmp = "";
                continue;
            }
            if (paramCheck) paramBuffer.add(chars[i]);
            if (valueCheck) valueBuffer.add(chars[i]);
        }
        //System.out.print(pairs);
        Iterator<Map.Entry<String, String>> iterator = pairs.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            System.out.print(pair.getKey() + " ");
        }

        Iterator<Map.Entry<String, String>> iterator1 = pairs.entrySet().iterator();
        while(iterator1.hasNext())
        {
            Map.Entry<String, String> pair = iterator1.next();
            if (pair.getKey().equals("obj")){
                double doubleValue = 0.0;
                String stringValue = pair.getValue();
                try{
                    doubleValue = Double.parseDouble(stringValue);
                    if (stringValue.contains(".")){
                        System.out.println();
                        alert(doubleValue);}
                    else {
                        System.out.println();
                        alert(stringValue);
                    }
                }
                catch(NumberFormatException e){
                    System.out.println();
                    alert(stringValue);
                }
            }
        }*/
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
