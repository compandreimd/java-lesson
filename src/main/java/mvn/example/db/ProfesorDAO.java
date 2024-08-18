package mvn.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO implements IProfesorDAO {
    private Statement statement = null;
    private String TABLE = "Profesor";
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
    private static ProfesorDAO instance =  null;

    private ProfesorDAO(){}

    public static synchronized ProfesorDAO getInstance() {
        if(instance == null) instance = new ProfesorDAO();
        return instance;
    }

    @Override
    public void addProfesor(Profesor p) {
        try {
            getStatement(false)
                    .executeUpdate("INSERT INTO " + TABLE + " VALUE (null, '"+p.getNumeProf()+"', '"+p.getPrenumeProf()+"')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Profesor getProfesor(int id) {
        try {
            var res = getStatement(false)
                    .executeQuery("SELECT * FROM " + TABLE + " WHERE idProfesor = " + id);
            if (res.next()) {
                return new Profesor(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3)
                );
            } else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Profesor> getAllProfesors() {
        List<Profesor> list = new ArrayList<>();
        try {
            var res = getStatement(false)
                    .executeQuery("SELECT * FROM " + TABLE);
            while (res.next()) {
                list.add(new Profesor(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    @Override
    public void updateProfesor(Profesor p) {
        try {
            getStatement(false)
                    .executeUpdate("UPDATE " + TABLE + " " +
                            "SET numeProf = '" + p.getNumeProf() + "'," +
                            "prenumeProf = '" + p.getPrenumeProf() + "'," +
                            "WHERE idProfesor = " + p.getIdProfesor());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteProfesor(int id) {
        try {
            getStatement(false)
                    .executeUpdate("DELETE FROM " + TABLE + " WHERE idProfesor = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Profesor profesor) {
        addProfesor(profesor);
    }

    @Override
    public Profesor get(Integer id) {
        if(id == null) id = 0;
        return getProfesor(id);
    }

    @Override
    public List<Profesor> getAll() {
        return getAllProfesors();
    }

    @Override
    public void update(Profesor p) {
        updateProfesor(p);
    }

    @Override
    public void delete(Integer id) {
        deleteProfesor(id);
    }
}
