package mvn.example.db;

import lombok.Getter;
import lombok.Setter;

public class Profesor {
    @Getter @Setter
    private int idProfesor;
    @Getter @Setter
    private String numeProf;
    @Getter @Setter
    private String prenumeProf;

    public Profesor(int idProfesor, String numeProf, String prenumeProf) {
        this.idProfesor = idProfesor;
        this.numeProf = numeProf;
        this.prenumeProf = prenumeProf;
    }

    public Profesor() {
    }
}
