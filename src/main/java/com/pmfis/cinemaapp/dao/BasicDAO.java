package com.pmfis.cinemaapp.dao;

import java.util.List;

public interface BasicDAO<T> {
    List<T> getAll();
    T getById(int id);
    T create(T entity);
    T update(int id, T entity);
    T delete(int id);
}
