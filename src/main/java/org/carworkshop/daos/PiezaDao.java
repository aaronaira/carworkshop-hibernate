package org.carworkshop.daos;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.Pieza;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class PiezaDao implements Dao<Pieza> {


    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public PiezaDao() {

    }

    @Override
    public Optional<Pieza> get(int id) {

        return Optional.ofNullable(entityManager.find(Pieza.class, id));
    }



    @Override
    public List<Pieza> getAll() {
        List<Pieza> allPiezas;
        allPiezas = entityManager.createQuery("from Pieza ", Pieza.class).getResultList();
        return allPiezas;

    }


    @Override
    public void save(Pieza pieza) {
        execute(entityManager -> entityManager
                .persist(pieza));

    }

    @Override
    public void update(Pieza pieza) {
        execute(entityManager -> entityManager.merge(pieza));

    }

    @Override
    public void delete(Pieza pieza) {
        execute(entityManager -> entityManager.remove(pieza));
    }


    private void execute(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw  e;
        }
    }
}
