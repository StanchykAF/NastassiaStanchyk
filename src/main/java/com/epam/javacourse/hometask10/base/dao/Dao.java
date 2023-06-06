package com.epam.javacourse.hometask10.base.dao;

import java.util.List;

public interface Dao<T> {
    T get(int id);
    List<T> getAll();
    List<T> getBetween(String column, int start, int end);
    List<T> getIn(String column, List<String> list);
    List<T> getLike(String column, String pattern);
    void add(T object);
    void delete(String column, String value);
    void delete(String column, int value);
    void truncate();
    void update(String column, String newValue);
    void update(String column, int newValue);
}
