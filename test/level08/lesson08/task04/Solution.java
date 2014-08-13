package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args) {
    /*    Date test = new Date("JUNE 7 1990");
        int month = test.getMonth();
        System.out.print(month);*/
    HashMap<String, Date> map = createMap();
    removeAllSummerPeople(map);
    for(Map.Entry<String, Date> pair : map.entrySet()){
        String key = pair.getKey();
        Date value = pair.getValue();
        System.out.println(key + " - " + value);
    }
    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Кличко", new Date("JUNE 2 1965"));
        map.put("Шевченко", new Date("JUNE 3 1966"));
        map.put("Попов", new Date("JUNE 4 1967"));
        map.put("Кармазов", new Date("JUNE 5 1968"));
        map.put("Лебедев", new Date("JUNE 6 1969"));
        map.put("Вархамов", new Date("JUNE 7 1970"));
        map.put("Кикабидзе", new Date("JUNE 8 1971"));
        map.put("Габаев", new Date("JUNE 9 1972"));
        map.put("Скорых", new Date("FEBRUARY 10 1973"));

        //Напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            int month = value.getMonth();
            if ((month == 5) || (month == 6) || (month == 7)) iterator.remove();
        }
    }
}
