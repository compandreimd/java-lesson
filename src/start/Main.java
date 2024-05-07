package start;

import vars.DemoVars;

public class Main {
    public static void main(String[] args){
        System.out.println("From Main.main");
        DemoStart.main(args);
        Andrei.main(args);
        DemoVars demoVars = new DemoVars();
        demoVars.demo();
    }
}
