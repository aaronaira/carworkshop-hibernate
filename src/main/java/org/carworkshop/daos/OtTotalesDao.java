package org.carworkshop.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.OtTotales;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OtTotalesDao implements Dao<OtTotales> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public OtTotalesDao() {

    }

    @Override
    public Optional<OtTotales> get(int id) {
        return Optional.ofNullable(entityManager.find(OtTotales.class, id));
    }



    @Override
    public List<OtTotales> getAll() {
        List<OtTotales> allOtTotales;
        allOtTotales = entityManager.createQuery("from OtTotales", OtTotales.class).getResultList();
        return allOtTotales;
    }


    @Override
    public void save(OtTotales otTotales) {
        execute(entityManager -> entityManager.persist(otTotales));

    }

    @Override
    public void update(OtTotales otTotales) {
        execute(entityManager -> entityManager.merge(otTotales));

    }

    @Override
    public void delete(OtTotales otTotales) {
        execute(entityManager -> entityManager.remove(otTotales));
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
