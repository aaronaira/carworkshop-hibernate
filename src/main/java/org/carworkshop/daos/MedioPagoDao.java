package org.carworkshop.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.MedioPago;
import org.carworkshop.entities.Vehiculo;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;


public class MedioPagoDao implements Dao<MedioPago> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();


    public MedioPagoDao() {
    }

    public void create(Vehiculo vehiculo) {
        execute(entityManager -> entityManager.persist(vehiculo));
    }


    @Override
    public Optional<MedioPago> get(int id) {

        return Optional.ofNullable(entityManager
                .createQuery("from MedioPago c where id = :id", MedioPago.class)
                .setParameter("id", id)
                .getResultStream().findFirst().orElse(null));
    }

    @Override
    public Optional<MedioPago> get(String email) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<MedioPago> getAll() {
        List< MedioPago > allMedioPagos;
        allMedioPagos = entityManager
                .createQuery("from MedioPago", MedioPago.class)
                .getResultList();
        return allMedioPagos;
    }

    @Override
    public List<MedioPago> getAll(int id) {

        return null;
    }

    @Override
    public void save(MedioPago medioPago) {
        execute(entityManager -> entityManager
                .persist(medioPago));
    }

    @Override
    public void update(MedioPago medioPago) {

        execute(entityManager -> entityManager
                .merge(medioPago));
    }

    @Override
    public void delete(MedioPago medioPago) {

        execute(entityManager -> entityManager
                .remove(medioPago));
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
