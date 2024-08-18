package mvn.example.db;

import java.util.List;

public interface IStudentDAO {
    void addStudent(Student s);
    Student getStudent(int id);
    List<Student> getAllStudents();
    void updateStudent(Student s);
    void deleteStudent(int id);
}
