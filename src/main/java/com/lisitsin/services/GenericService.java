package com.lisitsin.services;

import java.util.List;

public interface GenericService <T, ID>{
    T getById(ID id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    void deleteById(ID id);
}
