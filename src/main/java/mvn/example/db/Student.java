package mvn.example.db;

import lombok.Getter;
import lombok.Setter;

public class Student {
    @Getter @Setter
    private int idStudent;
    @Getter @Setter
    private String numeStudent;
    @Getter @Setter
    private String prenumeStudent;
    @Getter @Setter
    private int codeProf;

    public Student(int idStudent, String numeStudent, String prenumeStudent, int codeProf) {
        this.idStudent = idStudent;
        this.numeStudent = numeStudent;
        this.prenumeStudent = prenumeStudent;
        this.codeProf = codeProf;
    }

    @Override
    public String toString() {
        String s = super.toString()+"(";
        s += idStudent + ", ";
        s += numeStudent + ", ";
        s += prenumeStudent + ", ";
        s += codeProf + ")";

        return s;
    }
}
