package game;

import start.Main;

import java.util.Random;
import java.util.Scanner;

public class UFO {
    static final Random randomNumberGenerator = new Random();
    static final Scanner scanner = new Scanner(System.in);
    public static String message(int pc, String my){
        if(pc == 0) //rock
        {
            if(my.equals("r")){ //r = r
                return ("Equality all have rock");
            } else if(my.equals("s")) { // r = s
               return("Rock(PC) beat scissors (Me).");
            }
            else { // r = p
               return("Paper(Me) beat rock(Me).");
            }
        }
        else if(pc == 1) //paper
        {
            if(my.equals("p")){ //p = p
               return("Equality all have paper");
            } else if(my.equals("s")) { //p = s
               return("Scissors(Me) beat paper (PC).");
            }
            else { //p = r
               return("Paper (PC) beat rock(Me).");
            }

        }
        else //scissors
        {
            if(my.equals("p")){
               return("Scissors(PC) beat paper (ME)!");
            } else if(my.equals("s")) {
               return("Equality all have scissors!");
            }
            else {
               return("Rock(Me) beat scissors (PC).");
            }
        }
    }
    public static void main(String[] args) {
        //p,f,h,
        System.out.print("Choose r(rock), s(scissors), p(paper)?");
        String my = scanner.nextLine();
        int i = 0;
        while (!(my.equals("r") || my.equals("s")|| my.equals("p"))){
           if(++i >= 3){
                System.out.println("There is no point!");
                //(Exit app)
                return;
            }
            System.out.print("Choose r(rock), s(scissors), p(paper)?");
            my = scanner.nextLine();
        }
        int pc = randomNumberGenerator.nextInt(0,100) % 3;

        System.out.println(UFO.message(pc, my));
    }
}
