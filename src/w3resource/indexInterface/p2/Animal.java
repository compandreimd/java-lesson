package w3resource.indexInterface.p2;

public interface Animal {
    default void bark(){
        System.out.println("I am barking");
    }
}
