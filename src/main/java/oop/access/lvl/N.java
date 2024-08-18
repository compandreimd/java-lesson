package oop.access.lvl;

import oop.access.A;

public class N {
   public static class NA extends A {
        public static void show(){
            A a = new A();
            a.mPub();
            //! a.mPro();
            NA na = new NA();
            na.mPub();
            na.mPro();
           //! na.mDef();
        }
        public void show(boolean b){
            mPub();
            mPro();
           //! mDef();
        }
    }
    public static void main(String[] args) {
        A a = new A();
        a.mPub();
        //! a.mPro();
        //! a.mDef();
    }
}
