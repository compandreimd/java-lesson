package graph;

import java.awt.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UFO extends Frame {
    Label Result;
    UFO(){
        super();
        setSize(300,100);
        setTitle("UFO");
        setLayout(null);
        generate();
        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);

    }
    public void game(String me){
        String pc =  game.UFO.pcChoose();
        Result.setText(game.UFO.message(pc, me));
    }

    public void generate(){
        Button Rock = new Button("Rock");
        Button Paper = new Button("Paper");
        Button Scissor = new Button("Scissor");
        Result = new Label("Let's play!");
        Result.setBounds(30,30, 300, 30);
        add(Result);
        Paper.setBounds(0,60, 100, 30);
        add(Paper);
        Rock.setBounds(100,60, 100, 30);
        add(Rock);
        Scissor.setBounds(200,60, 100, 30);
        add(Scissor);
        Paper.addActionListener(e -> {
            game("p");
        });
        Scissor.addActionListener(e -> {
            game("s");
        });
        Rock.addActionListener(e -> {
            game("r");
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
