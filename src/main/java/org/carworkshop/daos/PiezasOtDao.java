package org.carworkshop.daos;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.PiezasOt;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class PiezasOtDao implements Dao<PiezasOt> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public PiezasOtDao() {
    }

    @Override
    public Optional<PiezasOt> get(int id) {
        return Optional.ofNullable(entityManager.find(PiezasOt.class, id));
    }



    @Override
    public List<PiezasOt> getAll() {
        List<PiezasOt> allPiezasOt;
        allPiezasOt = entityManager.createQuery("from PiezasOt ", PiezasOt.class).getResultList();
        return allPiezasOt;

    }




    @Override
    public void save(PiezasOt piezasOt) {
        execute(entityManager -> entityManager
                .persist(piezasOt));
    }

    @Override
    public void update(PiezasOt piezasOt) {
        execute(entityManager -> entityManager.merge(piezasOt));
    }

    @Override
    public void delete(PiezasOt piezasOt) {
        execute(entityManager -> entityManager.remove(piezasOt));
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