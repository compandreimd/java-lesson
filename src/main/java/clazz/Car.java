package clazz;

public class Car {
    public int price = 1000;
    public String color = "red";
    public int kms = 0;

    public int getPrice(){
        return  price;
    }

    public String getColor() {
        return color;
    }

    public int getKms() {
        return kms;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
