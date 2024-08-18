package mvn.example.patterns.dao;

import java.util.List;

public interface IDAO<T,V>{
    void add(T t);
    T get(V id);
    List<T> getAll();
    void update(T p);
    void delete(V id);
}
