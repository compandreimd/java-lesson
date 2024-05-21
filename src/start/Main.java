package start;

import condition.Ifs;
import homework.HW1;
import oper.Operation;
import vars.DemoVars;
import condition.Ex;

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

        while (s.compareTo("Exit") != 0){
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
                    HW1.Media();
                    break;
                case "Ex":
                    System.out.println("Ex (1, 2):?");
                    s = scan.nextLine();
                    if(s.compareTo("1") == 0)
                        Ex.ex1();
                    if(s.compareTo("2") == 0)
                        Ex.ex2();
                    break;
                case "IFS":
                case "Main":
                    default:
                        System.out.println("Choose Class (if, ifelse, ifelseif):?");
                        s = scan.nextLine();
                        if(s.compareTo("if") == 0)
                            Ifs.mIf();
                        else if(s.compareTo("ifelseif") == 0)
                            Ifs.mIfElseIf();
                        else
                            Ifs.mIfElse();
            }
            System.out.println("Choose Class (Andrei, DemoStart, Main, Vars, Operation, HW1, C1, IFS, EXIT):?");
            s = scan.nextLine();

        }
    }
}
