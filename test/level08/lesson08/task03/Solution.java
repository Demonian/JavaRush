package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{

    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Ovcharenko","Aleks");
        map.put("Barabanshikova","Elena");
        map.put("Porohnja","Lidia");
        map.put("Platash","Artem");
        map.put("Suhorutchenko","Ivan");
        map.put("Efrosinin","Oleg");
        map.put("Starchenko","Aleks");
        map.put("Stelmah","Anton");
        map.put("Sharun","Bogdan");
        map.put("Nenja","Dmitrii");
        int frstname = getCountTheSameFirstName(map,"Ovcharenko");
        int scndname = getCountTheSameLastName(map,"Aleks");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int result = 0;
        while(iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getValue();
            if (key.equals(name)) result++;
        }
    return result;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //Напишите тут ваш код
    Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int result = 0;
        while(iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            String value = pair.getKey();
            if (value.equals(familiya)) result++;
        }
    return result;
    }
}
