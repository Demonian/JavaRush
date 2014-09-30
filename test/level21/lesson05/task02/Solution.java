package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        if (first != null) this.first = first;
        else this.first = "";
        if (first != null) this.last = last;
        else this.last = "";
    }

    public boolean equals(Object o) {
        if (o != null && o instanceof Solution){
            Solution in = (Solution) o;
            if (in.first != null && in.last != null && first != null && last != null) return in.first.equals(first) && in.last.equals(last);
            if (in.first == null && in.last == null && first == null && last == null) return true;
            if ("".equals(in.first) && "".equals(first) && ("".equals(in.last) || "".equals(last))) return false;
            if ("".equals(in.first) && "".equals(first) && !"".equals(in.last) && !"".equals(last)) return in.last.equals(last);
            if ("".equals(in.last) && "".equals(last) && ("".equals(in.first) || "".equals(in.last))) return false;
            if (in.last == null && last == null && in.first != null && first != null) return in.first.equals(first);
        }
        return false;
    }

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        try{
            if (!first.isEmpty()) for (int i = 0; i < first.length(); i++) result += first.codePointAt(i);
        } catch (NullPointerException npe){
        }
        try{
            if (!last.isEmpty()) for (int i = 0; i < last.length(); i++) result += last.codePointAt(i);
        } catch (NullPointerException npe){
        }
        return result * prime;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution(null, null).equals(new Solution(null, null)));
        Set<Solution> s = new HashSet<Solution>();
        s.add(new Solution( "Donald", "Duck" ));
        s.add(new Solution( null, "Duck" ));
        s.add(new Solution( "Donald", null ));
        s.add(new Solution( null, null ));

        System.out.println(s.contains(new Solution( "Donald", "Duck" )));
        System.out.println(s.contains(new Solution( null, "Duck" )));
        System.out.println(s.contains(new Solution( "Donald", null )));
        System.out.println(s.contains(new Solution( null, null)));
    }
}
