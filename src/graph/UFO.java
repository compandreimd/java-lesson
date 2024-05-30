package graph;

import java.awt.*;
import java.util.Random;

public class UFO extends Frame {
    static final Random randomNumberGenerator = new Random();
    UFO(){
        super();
        setSize(300,300);
        setTitle("UFO");
        setLayout(null);
        generate();
        setVisible(true);
    }
    public void game(String me){
        int pc =  randomNumberGenerator.nextInt(0,100) % 3;

    }
    public void generate(){
        Button Rock = new Button("Rock");
        Button Paper = new Button("Paper");
        Button Scissor = new Button("Scissor");
        Label Result = new Label("Let's play!");
        Result.setBounds(30,30, 300, 30);
        add(Result);
        Paper.setBounds(0,60, 100, 30);
        add(Paper);
        Rock.setBounds(100,60, 100, 30);
        add(Rock);
        Scissor.setBounds(200,60, 100, 30);
        add(Scissor);

        Paper.addActionListener(() => {

        });
        // setting button position on screen
        //b.setBounds(0,0,80,30);

        // adding button into frame
       // add(b);
    }
    static public void main(String[] args) {
        Frame f = new UFO();

    }
}
