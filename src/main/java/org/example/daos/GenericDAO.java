package org.example.daos;

public interface GenericDAO<T> {

    void create(T obj);

    T get(int id);

    void update(int id, T obj);

    void delete(int id);
}
