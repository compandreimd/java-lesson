package oop.access;

public class A
{
    //1 public
    //2 protected
    //3 default
    //4 private
    public void mPub(){
        System.out.println("i AM PUBLIC!");
    }
    protected void mPro(){
        System.out.println("i am Protected ");
    }
    void mDef(){
        System.out.println("i am Default");
    }
    private void mPriv(){
        System.out.println("i am Default");
    }
}