package org.carworkshop.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.ManoobraOt;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ManoobraOtDao implements Dao<ManoobraOt> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public ManoobraOtDao() {

    }

    @Override
    public Optional<ManoobraOt> get(int id) {
        return Optional.ofNullable(entityManager.find(ManoobraOt.class, id));
    }


    @Override
    public Optional<ManoobraOt> get(String email) {

        return null;
    }

    @Override
    public List<ManoobraOt> getAll() {
        List<ManoobraOt> allManoobraOt;
        allManoobraOt = entityManager.createQuery("from ManoobraOt", ManoobraOt.class).getResultList();
        return allManoobraOt;
    }

    @Override
    public List<ManoobraOt> getAll(int id) {
        return null;
    }

    @Override
    public void save(ManoobraOt manoobraOt) {
        execute(entityManager -> entityManager.persist(manoobraOt));

    }

    @Override
    public void update(ManoobraOt manoobraOt) {
        execute(entityManager -> entityManager.merge(manoobraOt));

    }

    @Override
    public void delete(ManoobraOt manoobraOt) {
        execute(entityManager -> entityManager.remove(manoobraOt));
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
