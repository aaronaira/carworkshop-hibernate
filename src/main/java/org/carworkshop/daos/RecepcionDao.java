package org.carworkshop.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Pieza;
import org.carworkshop.entities.Recepcion;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class RecepcionDao implements Dao<Recepcion> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public RecepcionDao() {

    }


    @Override
    public Optional<Recepcion> get(int id) {
        return Optional.ofNullable(entityManager.find(Recepcion.class, id));
    }

    @Override
    public Optional<Recepcion> get(String email) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Recepcion> getAll() {
        List<Recepcion> allReceptions;
        allReceptions = entityManager.createQuery("from Recepcion", Recepcion.class).getResultList();
        return allReceptions;

    }

    @Override
    public List<Recepcion> getAll(int id) {
        return null;
    }

    @Override
    public void save(Recepcion recepcion) {
        execute(entityManager -> entityManager.persist(recepcion));

    }

    @Override
    public void update(Recepcion recepcion) {
        execute(entityManager -> entityManager.merge(recepcion));

    }

    @Override
    public void delete(Recepcion recepcion) {
        execute(entityManager -> entityManager.remove(recepcion));
    }

    private void execute(Consumer<EntityManager> action) throws RuntimeException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        action.accept(entityManager);
        tx.commit();
    }
}
