package mvn.example.patterns.dao;

import mvn.example.db.DB;

import java.util.ArrayList;
import java.util.List;

public  class DAO<T, V> implements IDAO<T, V> {

    public interface Field<T, K> {
        K get(T t);
        void set(K k, T t);
        String name();
    }
    public interface KeyField<T, K> extends Field<T, K> {};
    private DB db;
    private String table;

    private List<Field> fields = new ArrayList<>();

    public DAO<T, V> addField(Field field){
        fields.add(field);
        return this;
    }
    public DAO<T, V> removeField(Field field){
        fields.remove(field);
        return this;
    }
    public List<KeyField> getKeysField(){
        return fields.stream().filter(f -> f instanceof DAO.KeyField<?,?>).map(f -> (DAO.KeyField) f).toList();
    }
    public DAO(DB db, String table){
        this.db = db;
        this.table = table;
   }

    @Override
    public void add(T t) {

    }

    @Override
    public T get(V id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public void update(T p) {

    }

    @Override
    public void delete(V id) {

    }

}
