package com.javarush.test.level20.lesson10.bonus03;

import java.util.LinkedList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endX) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "hooe", "same", "emoh", "emas", "fderlk", "klredf", "fulmp", "poeejj", "jjeeop",
                "pmlif", "kovhj", "jhvok", "lprr", "rrpl", "lprr", "o", "test", "eo", "oe", " ");
        System.out.println(list.toString());
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }
    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> newWords = new LinkedList<Word>();
        for (String string : words){
            Word word = searchWord(new Word(string), crossword);
            if (word != null) newWords.add(word);
        }
        return newWords;
    }
    public static Word searchWord(Word word, int[][] crossword){
        if (word == null) return null;
            for (int y = 0; y < crossword.length; y++) {
                for (int x = 0; x < crossword[y].length; x++) {
                    try{
                        if (word.text.codePointAt(0) == crossword[y][x]) {
                            if ((word = searchNextLetter(word,1,crossword,x,y,0)) != null) {
                                word.setStartPoint(x,y);
                                return word;
                            }
                        }
                    }catch (NullPointerException npe){
                        System.out.println("NPE in Sw");
                    }
                }
            }
        return null;
    }

    public static Word searchNextLetter(Word word, int index, int[][] crossword, int prevX, int prevY,int direction){
        if (word == null) return null;
        int currentDirection = 0;
        for (int y = prevY - 1; y < prevY + 2; y++){
            for (int x = prevX - 1; x < prevX + 2; x++){
                currentDirection++;
                if ((currentDirection == direction) || (direction == 0)){
                    try{
                        if ((y > -1 && y < crossword.length) || (x > -1 && x < crossword[y].length)){
                            if (word.text.codePointAt(index) == crossword[y][x]){
                                if (index + 1 == word.text.length()){
                                    word.setEndPoint(x, y);
                                    return word;
                                }
                                if (searchNextLetter(word, index + 1, crossword, x, y, currentDirection) != null){
                                    word = searchNextLetter(word, index + 1, crossword, x, y, currentDirection);
                                    return word;
                                }
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ex){
                        System.out.println("AIOOBE in Sw");
                    } catch (NullPointerException npe){
                        System.out.println("NPE in Sw");
                    } catch (Exception e){
                        System.out.println("E in Sw");
                    }
                }
            }
        }
        return null;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
