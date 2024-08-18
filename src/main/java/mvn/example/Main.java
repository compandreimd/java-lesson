package mvn.example;

import mvn.example.lombok.StLombok;
import mvn.example.patterns.builder.St2;
import mvn.example.patterns.builder.St2Builder;

public class Main {
        public static void main(String[] args) {
                StLombok test = StLombok.builder()
                        .nume("John`")
                       // .ani(10)
                        .build();
                System.out.println(test.toString());
        }
}
