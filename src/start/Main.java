package start;

import condition.Ifs;
import homework.HW1;
import oper.Operation;
import vars.DemoVars;
import condition.Ex;
import w3resource.base.Base1;
import w3resource.base.Conditional;

import java.util.Scanner;

public class Main {
    public static boolean isRepeat(String arg){
        return arg.contentEquals("1")||arg.contentEquals("yes")||arg.contentEquals("y");
    }
    public static void main(String[] args){
        Scanner scan =  new Scanner(System.in);

        String s = "";
        String bs = "";
        boolean b = false;
        if(args.length > 0) {
            s = args[0];
            if(args.length > 1){
                    b = isRepeat(args[1]);
            }
        }
        else {
            System.out.println("Choose Class (Andrei, DemoStart, Main, Vars, Operation, HW1 ...):?");
            s = scan.nextLine();
            System.out.print("Repeat:");
            bs = scan.nextLine();
            b = isRepeat(bs);
        }
      //  scan.close();
        Conditional cond = new Conditional();
        while (s.compareTo("Exit") != 0 && b){
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
                case "w3.c.1":
                    cond.Ex1();
                    break;
                case "w3.c.2":
                    cond.Ex2();
                    break;
                case "w3.c.3":
                    cond.Ex3();
                    break;
                case "w3.c.4":
                    cond.Ex4();
                    break;
                case "w3.c.5":
                    cond.Ex5();
                    break;
                case "w3.c.6":
                    cond.Ex6();
                    break;
                case "w3.c.7":
                    cond.Ex7();
                    break;
                case "w3.c.8":
                    cond.Ex8();
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
            if(!b) {
                System.out.println("Choose Class (Andrei, DemoStart, Main, Vars, Operation, HW1, C1, IFS, Exit ...):?");
                s = scan.nextLine();
            }
            else {
                System.out.print("Repeat:");
                bs = scan.nextLine();
                b = isRepeat(bs);
                if(!b) s = "Exit";
            }
        }
    }
}
