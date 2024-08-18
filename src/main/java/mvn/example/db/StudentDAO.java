package mvn.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private Statement statement = null;
    private String TABLE = "Student";
    private StudentDAO(){}
    private static StudentDAO instance = null;

    public static synchronized StudentDAO getInstance() {
        if(instance == null) instance = new StudentDAO();
        return instance;
    }

    private Statement getStatement(boolean force) {
        if (statement != null && !force)
            return statement;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/andrei",
                    "root", "rIkYS6aa");
            statement = connection.createStatement();
        } catch (SQLException e) {
            // throw new RuntimeException(e);
            System.out.println(e);
        }
        return statement;
    }
    @Override
    public void addStudent(Student s) {
        try {
            getStatement(false)
                    .executeUpdate("INSERT INTO " + TABLE + " VALUE (null, '" +
                            s.getNumeStudent() + "', '" +
                            s.getPrenumeStudent() + "', + " + s.getCodeProf() + ");");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Student getStudent(int id) {
        try {
            var res = getStatement(false)
                    .executeQuery("SELECT * FROM " + TABLE + " WHERE idStudent = " + id);
            if (res.next()) {
                return new Student(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4)
                );
            } else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try {
            var res = getStatement(false)
                    .executeQuery("SELECT * FROM " + TABLE);
            while (res.next()) {
                list.add(new Student(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    @Override
    public void updateStudent(Student s) {
        try {
            getStatement(false)
                    .executeUpdate("UPDATE " + TABLE + " " +
                            "SET numeStudent = '" + s.getNumeStudent() + "'," +
                            "prenumeStudent = '" + s.getPrenumeStudent() + "'," +
                            "codeProf = " + s.getCodeProf() +
                            " WHERE idStudent = " + s.getIdStudent());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteStudent(int id) {
        try {
            getStatement(false)
                    .executeUpdate("DELETE FROM " + TABLE + " WHERE idStudent = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
