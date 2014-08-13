package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }


    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData original;
        public IncomeDataAdapter(IncomeData input){
            this.original = input;
        }

        @Override
        public String getName()
        {
            return original.getContactLastName() + ", " + original.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
            StringBuilder result = new StringBuilder();
            result.append("+");
            result.append(original.getCountryPhoneCode());

            StringBuilder tmp = new StringBuilder();
            tmp.append(original.getPhoneNumber());
            while(tmp.length() < 10){
                tmp.insert(0,'0');
            }

            result.append("(");
            result.append(tmp.substring(0,3));
            result.append(")");
            result.append(tmp.substring(3,6));
            result.append("-");
            result.append(tmp.substring(6,8));
            result.append("-");
            result.append(tmp.substring(8,10));
            return result.toString();
        }

        @Override
        public String getCompanyName()
        {
            return original.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(original.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}