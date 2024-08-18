package main.java.w3resource.indexInterface.p1;

import main.java.w3resource.indexInterface.p6.Drawable;

public class Circle implements Shape, Drawable
{
    private int radius = 0;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public void draw() {
        System.out.println("*");
        System.out.println("* *");
        System.out.println("*   *");
        System.out.println("* *");
        System.out.println("*");
    }
}
