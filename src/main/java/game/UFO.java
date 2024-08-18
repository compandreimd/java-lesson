package main.java.game;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class UFO {
    static Socket socket = null;
    static String name = null;
    static String my;
    static final Random randomNumberGenerator = new Random();
    static Scanner scanner;
    static Scanner sScanner;
    static PrintWriter writer;
    static PrintWriter sWritter;
    public static void setMainInput(InputStream in){
        scanner = new Scanner(in);
    }
    public static void setMainOutput(OutputStream out){
       writer =  new PrintWriter(out, true);
    }
    public static void setSerInput(InputStream in){
        sScanner = new Scanner(in);
    }
    public static void setSerOutput(OutputStream out){sWritter =  new PrintWriter(out, true);}


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
        ServerSocket serverSocket = new ServerSocket(port);
        while (true){

            socket = serverSocket.accept();
            if(name != null) {
                writer.println("Name:");
                name = scanner.nextLine();
            }
            setSerInput(socket.getInputStream());
            setSerOutput(socket.getOutputStream());
            if(sScanner.hasNextLine()){
                writer.println(sScanner.nextLine());
                writer.println(sScanner.nextLine());
            }
            serverSocket.close();

        }
        //Task task = new
//           while (true) {
//               socket = new ServerSocket(port).accept();
//               setInput(socket.getInputStream());
//               setOutput(socket.getOutputStream());
//               System.out.println("hERE");
//           }

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

        setSerInput(socket.getInputStream());
        setSerOutput(socket.getOutputStream());
        if(name != null) {
            writer.println("Name:");
            name = scanner.nextLine();
        }
        sWritter.println(name);
        sWritter.println("Connect");
    }
    public static void main(String @NotNull [] args) {
        setMainInput(System.in);
        setMainOutput(System.out);
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
            }
            else {
                String host = args[1];
                int port = Integer.parseInt(args[2]);
                Thread th = new Thread(() -> {
                    try {
                        client(host, port);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                th.start();
                System.out.println("Name:");
                name = scanner.nextLine();
            }
        }
        else if(socket == null) {
            String pc = pcChoose();
            String my = soutChoose();
            writer.println(message(pc, my));
        }
    }
}
