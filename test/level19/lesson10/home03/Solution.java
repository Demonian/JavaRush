package com.javarush.test.level19.lesson10.home03;

import org.omg.PortableServer.POA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args){
        if (args.length == 0) return;
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(args[0]));
        } catch (FileNotFoundException e){
        }

        String line = "";
        try
        {
            while ((line = reader.readLine()) != null)
            {
                StringBuilder nameBuffer = new StringBuilder();
                StringBuilder dateBuffer = new StringBuilder();
                boolean check = false;
                for (int i = 0; i < line.length(); i++)
                {
                    if (line.codePointAt(i) > 47 && line.codePointAt(i) < 58) check = true;

                    if (!check) nameBuffer.append(line.charAt(i));
                    else dateBuffer.append(line.charAt(i));
                }
                String[] dates = dateBuffer.toString().split(" ");
                int day = Integer.parseInt(dates[0]);
                int month = Integer.parseInt(dates[1]) - 1;
                int year = Integer.parseInt(dates[2]);
                PEOPLE.add(new Person(nameBuffer.toString().trim(), new GregorianCalendar(year, month, day).getTime()));
            }
            reader.close();
        } catch (IOException e){
        }
    }
}
