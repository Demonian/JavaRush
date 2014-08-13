package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    //Напишите тут ваш код
    public int centreX;
    public int centreY;
    public int radius;
    public int width;
    public String color;

    public void initialize(int centreX, int centreY, int radius){
        this.centreX = centreX;
        this.centreY = centreY;
        this.radius = radius;
    }

    public void initialize(int centreX, int centreY, int radius, int width){
        this.centreX = centreX;
        this.centreY = centreY;
        this.radius = radius;
        this.width = width;
    }

    public void initialize(int centreX, int centreY, int radius, int width, String color){
        this.centreX = centreX;
        this.centreY = centreY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }

}
