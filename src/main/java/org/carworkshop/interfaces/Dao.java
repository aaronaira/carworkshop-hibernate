package org.carworkshop.interfaces;

import jakarta.persistence.Query;
import java.util.Optional;

import java.util.List;

public interface Dao<T> {
    Optional<T> get(int id);

    Optional<T> get(String email) throws Exception;

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}