package com.javarush.test.level20.lesson10.bonus02;

import java.util.LinkedList;
import java.util.List;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 8");
    }

    public static int getRectangleCount(byte[][] a) {
        List<Rectangle> rectangles = new LinkedList<Rectangle>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if ( a[i][j] == 1) checkOwn(rectangles,i,j);
            }
        }
        return rectangles.size();
    }

    public static void checkOwn(List<Rectangle> rectangles,int coordX, int coordY){
        if (rectangles.size() == 0) {
            createRectangle(rectangles,coordX, coordY);
            return;
        }
        for (Rectangle rectangle : rectangles) if (rectangle.checkIsNear(coordX,coordY)) return;
        createRectangle(rectangles,coordX,coordY);
    }

    public static void createRectangle(List<Rectangle> rectangles,int coordX, int coordY){
        Rectangle newRectangle = new Rectangle();
        newRectangle.x.add(coordX);
        newRectangle.y.add(coordY);
        rectangles.add(newRectangle);
    }

    public static class Rectangle{
        public List<Integer> x = new LinkedList<Integer>();
        public List<Integer> y = new LinkedList<Integer>();

        public boolean checkIsNear(int coordX, int coordY){
            if (((coordY - 1) == y.get(y.size() - 1)) && (coordX == x.get(x.size() - 1))){
                x.add(coordX);
                y.add(coordY);
                return true;
            }
            if (((coordX - 1) == x.get(x.size() - 1)) && checkY(coordY)) {
                x.add(coordX);
                y.add(coordY);
                return true;
            }
            return false;
        }

        public boolean checkY(int coordY){
            for (int i = 0; i < y.size(); i++) if (y.get(i) == coordY) return true;
            return false;
        }
    }
}
