package oop;

public interface IRec extends ICalc {
    int message(String str);
    default int sum(){
        return 100;
    }
}
