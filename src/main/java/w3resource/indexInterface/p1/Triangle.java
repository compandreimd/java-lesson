package w3resource.indexInterface.p1;

import w3resource.indexInterface.p6.Drawable;

public class Triangle implements Shape, Drawable {
    private int height;
    private int base;

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return height*base/2;
    }

    @Override
    public void draw() {
        System.out.println("*");
        System.out.println("***");
        System.out.println("******");
    }
}
