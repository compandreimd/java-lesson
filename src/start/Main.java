package start;

import homework.HW1;
import oper.Operation;
import vars.DemoVars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan =  new Scanner(System.in);

        String s = "";
        if(args.length > 0)
            s = args[0];
        else {
            System.out.println("Choose Class (Andrei, DemoStart, Main, Vars, Operation, HW1):?");
            s = scan.nextLine();
        }
      //  scan.close();

        switch (s){
            case "Andrei":
                Andrei.main(args);
            case "Vars":
                var demo = new DemoVars();
                demo.demo();
            case "DemoStart":
                DemoStart.main(args);
            break;
            case "Operation":
                Operation.calc();
                break;
            case "HW1":
            case "Main":
                default:
                    HW1.Media();
        }
        scan.close();
    }
}
