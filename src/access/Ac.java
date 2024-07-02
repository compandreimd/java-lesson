package access;

import oop.access.A;
import oop.access.lvl.N;

public class Ac {

    public static class NA extends A {
        public static void show(){
            A a = new A();
            a.mPub();
            //! a.mPro();
            N.NA na = new N.NA();
            na.mPub();
            //! na.mPro();
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
        // !! a.mPro();
        // !! a.mDef();
    }

}
