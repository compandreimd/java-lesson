package mvn.example.patterns.singleton;

import lombok.Getter;
import lombok.Setter;

public class MainConfig {

    @Getter @Setter
    int age;
    @Getter @Setter
    String nume;
    static MainConfig persona = null;
    private MainConfig(){}

    public static synchronized MainConfig getInstance(){
        if(persona == null)
            persona = new MainConfig();

        return  persona;
    }
}
