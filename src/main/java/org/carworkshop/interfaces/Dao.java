package org.carworkshop.interfaces;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(int id);

    Optional<T> get(String email) throws Exception;

    List<T> getAll();

    List<T> getAll(int id);

    void save(T t);

    void update(T t);

    void delete(T t);
}