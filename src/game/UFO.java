package game;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class UFO {
    static InputStream input;
    static BufferedReader reader;
    static OutputStream output;
    static  PrintWriter writer;
    static Socket socket = null;
    static String name;
    static String my;
    static final Random randomNumberGenerator = new Random();
    static Scanner scanner;
    public static void setInput(InputStream in){
        input = in;
        scanner = new Scanner(in);
        reader = new BufferedReader(new InputStreamReader(input));
    }
    public static void setOutput(OutputStream out){
       output = out;
       writer =  new PrintWriter(output, true);
    }

    public static String message(String s, String my) {
        return  message(s, my, "PC", "MY");
    }
    @NotNull
    public static String message(String s, String my, String pName, String mName){
        if(my == null)
            return ( "There is no point!");
        if(s.equals("r")) //rock
        {
            if(my.equals("r")){ //r = r
                return ("Equality all have rock");
            } else if(my.equals("s")) { // r = s
               return ("Rock("+pName+") beat scissors ("+mName+").");
            }
            else { // r = p
               return("Paper("+pName+") beat rock("+mName+").");
            }
        }
        else if(s.equals("p")) //paper
        {
            if(my.equals("p")){ //p = p
               return ("Equality all have paper");
            } else if(my.equals("s")) { //p = s
               return ("Scissors("+mName+") beat paper ("+pName+").");
            }
            else { //p = r
               return ("Paper ("+pName+") beat rock("+mName+").");
            }

        }
        else if(s.equals("s")) //scissors
        {
            if(my.equals("p")){
               return ("Scissors("+pName+") beat paper ("+mName+")!");
            } else if(my.equals("s")) {
               return ("Equality all have scissors!");
            }
            else {
               return ("Rock("+mName+") beat scissors ("+pName+").");
            }
        }
        else {
            return ( "There is no point!");
        }
    }
    public static String pcChoose() {
        return  switch (randomNumberGenerator.nextInt(0,100) % 3) {
            case 0: yield "p";
            case 1: yield "s";
            case 2: yield "r";
            default: yield null;
        };

    }
    public static @Nullable String soutChoose(){
        writer.println("Choose r(rock), s(scissors), p(paper)?");
        String my = scanner.nextLine();
        int i = 0;
        while (!(my.equals("r") || my.equals("s")|| my.equals("p"))){
            if(++i >= 3){
                return null;
            }
            writer.print("Choose r(rock), s(scissors), p(paper)?");
            my = scanner.nextLine();
        }
        return my;
    }

    public static void server(int port) throws IOException{
        //Task task = new
           while (true) {
               socket = new ServerSocket(port).accept();
               setInput(socket.getInputStream());
               setOutput(socket.getOutputStream());
               System.out.println("hERE");
           }

//                writer.println("name");
//                String line = reader.readLine();
//                switch (line){
//                    case "name":
//                        System.out.println("Connected "+  reader.readLine());
//                        writer.println("choose");
//                        my = soutChoose();
//                        writer.println(m);
//
//                        break;
//                    case "end":
//                        String s  = reader.readLine();
//                        System.out.println(message(s, m));
//                        return;
//                }
//                //  return;
//            }

    }
    public static void client(String host, int port) throws IOException {
        socket = new Socket(host, port);

        System.out.println("hERE");
    }
    public static void main(String[] args) {
        setInput(System.in);
        setOutput(System.out);
        if(args.length >= 2){
            String choose = args[0];
            if(choose.startsWith("s")){
                int port = Integer.parseInt(args[1]);
                Thread th = new Thread(() -> {
                    try {
                        server(port);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                th.start();
                System.out.println("Name:");
                name = scanner.nextLine();
            }
        }else
//        System.out.println(args.length);
//        if(args.length >= 2){
//            String choose = args[0];
//            String m = "";
//            if(choose.startsWith("s")){
//                int port = Integer.parseInt(args[1]);
//
//
//            }
//            else {
//                String host = args[1];
//                int port = Integer.parseInt(args[2]);
//                System.out.println("Connecting at port "+port+".");
//                try {
//                    socket = new Socket(host, port);
//                    InputStream input = socket.getInputStream();
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//                    OutputStream output = socket.getOutputStream();
//                    PrintWriter writer = new PrintWriter(output, true);
//                    String line;
//                    do {
//                        line = reader.readLine();
//                        switch (line) {
//                            case "name":
//                                System.out.println("What your name?");
//                                writer.println("name");
//                                writer.println(scanner.nextLine());
//                                break;
//                            case "choose":
//                                String s = reader.readLine();
//                                m = soutChoose();
//                                writer.println("end");
//                                writer.println(m);
//                                System.out.println(message(s, m));
//                                return;
//                        }
//                    } while (!line.equals("exit"));
//
//                } catch (IOException e) {
//                    System.err.println(e);
//                    socket = null;
//
//                }
//            }
//        }
        if(socket == null) {
            String pc = pcChoose();
            String my = soutChoose();
            writer.println(message(pc, my));
        }
    }
}
