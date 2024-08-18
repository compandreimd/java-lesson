package mvn.example.db;

import mvn.example.patterns.dao.IDAO;

import java.util.List;

public interface IProfesorDAO extends IDAO<Profesor, Integer> {
    void addProfesor(Profesor p);
    Profesor getProfesor(int id);
    List<Profesor> getAllProfesors();
    void updateProfesor(Profesor p);
    void deleteProfesor(int id);
}
