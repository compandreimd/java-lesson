package core.web;

import org.testng.annotations.BeforeMethod;

public class Base {
    @BeforeMethod
    public void before(){
        System.out.println("Before");
    }
}
