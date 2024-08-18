package oop;

public interface ICalc  {
    int max = 100;
    int calc();
    default int sum(){
        return max + calc();
    }

}
