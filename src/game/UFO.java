package game;

import start.Main;

import java.util.Random;
import java.util.Scanner;

public class UFO {
    static final Random randomNumberGenerator = new Random();
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //p,f,h,
        System.out.println("Choose r(rock), s(scissors), p(paper)?");
        String my = scanner.nextLine();
        int pc = randomNumberGenerator.nextInt(0,100) % 3;
        if(pc == 0) //rock
        {
            if(my.equals("r")){ //r = r
                System.out.println("Equality all have rock");
            } else if(my.equals("s")) { // r = s
                System.out.println("Rock(PC) beat scissors (Me).");
            }
            else { // r = p
                System.out.println("Paper(Me) beat rock(Me).");
            }
        }
        else if(pc == 1) //paper
        {
            if(my.equals("p")){ //p = p
                System.out.println("Equality all have paper");
            } else if(my.equals("s")) { //p = s
                System.out.println("Scissors(Me) beat paper (PC).");
            }
            else { //p = r
                System.out.println("Paper (PC) beat rock(Me).");
            }

        }
        else //scissors
        {
            if(my.equals("p")){
                System.out.println("Scissors(PC) beat paper (ME)!");
            } else if(my.equals("s")) {
                System.out.println("Equality all have scissors!");
            }
            else {
                System.out.println("Rock(Me) beat scissors (PC).");
            }
        }

    }
}
