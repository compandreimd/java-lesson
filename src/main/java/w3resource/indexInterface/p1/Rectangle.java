package w3resource.indexInterface.p1;

import w3resource.indexInterface.p5.Resizable;
import w3resource.indexInterface.p6.Drawable;

public class Rectangle implements Shape, Drawable , Resizable {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea()
    {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("***");
        System.out.println("* *");
        System.out.println("* *");
        System.out.println("* *");
        System.out.println("***");
    }

    @Override
    public void resizeWidth(int width) {
        this.width *= width;
    }

    @Override
    public void resizeHeight(int height) {
        this.height *= height;
    }
}
