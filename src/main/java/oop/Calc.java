package oop;

public class Calc implements ICalc,IRec {
   private void read(){
       System.out.println(calc());
   }
    @Override
    public int calc() {
        return message("Get Me!");
    }

    @Override
    public int sum() {
       read();
       return 10;
    }

    @Override
    public int message(String str) {
        return 0;
    }
}
