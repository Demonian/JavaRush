package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args){
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        if(map.isEmpty()) System.out.println("Map is empty");
        else {
            for (Map.Entry<String, String> pair : map.entrySet()){
                System.out.println(pair.getKey() + " - " + pair.getValue());
                }
            }
        System.out.println(map.containsValue("Aleks"));
    }
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
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);
        Iterator<Map.Entry<String, String>> iterator0 = copy.entrySet().iterator();
        while(iterator0.hasNext()){
            String[] array = new String[10];
            int array_pointer = 0;
            Map.Entry<String, String> copy_pair = iterator0.next();
            Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();
            int check = 0;
            System.out.println("\n new iteration \n");
            while(iterator1.hasNext()){
                Map.Entry<String, String> pair = iterator1.next();
                System.out.println(copy_pair.getValue() + " - " + pair.getValue());
                if (copy_pair.getValue().equals(pair.getValue())) {
                    array[array_pointer] = pair.getKey();
                    array_pointer++;
                }
                /*if (check == 2) {
                    iterator1.remove();
                    check = 1;
                }*/

            }
        if (array_pointer > 1) {
            for(int i = 0; i < array_pointer; i++){
                map.remove(array[i]);
            }
        }
        }

        /*for(Map.Entry<String, String> copy_pair : copy.entrySet()){
            //String firstName = copy_pair.getValue();
            for (Map.Entry<String, String> pair : map.entrySet()){
                if (copy_pair.getValue().equals(pair.getValue())) map.remove(pair.getKey());
            }
        }*/

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
