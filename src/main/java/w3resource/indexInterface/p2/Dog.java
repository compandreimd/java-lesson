package main.java.w3resource.indexInterface.p2;

public class Dog implements Animal{
    @Override
    public void bark() {
        speak();
    }

    public void speak(){
        System.out.println("Dog is barking");
    }
}
