package com.nlxa.java.connector;

import java.util.List;

public interface IConnector<T,ID> {

    List<T> getAll();

    T getById(ID id);

    T save(T type);

    T update(T type);

    void delete(T type);

    void deleteById(ID id);

}
