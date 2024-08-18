package main.java.w3resource.indexInterface.p5;

public class Rectangle implements  Resizable{
    private int width;
    private int height;
    @Override
    public void resizeWidth(int width) {
        this.width += width;
    }

    @Override
    public void resizeHeight(int height) {
        this.height += height;
    }
}
