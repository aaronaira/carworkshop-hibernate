package org.carworkshop.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.Cita;
import org.carworkshop.entities.OtCabecera;
import org.carworkshop.entities.OtTotales;
import org.carworkshop.entities.Vehiculo;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OtCabeceraDao implements Dao<OtCabecera> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public OtCabeceraDao() {

    }

    @Override
    public Optional<OtCabecera> get(int id) {
        return Optional.ofNullable(entityManager.find(OtCabecera.class, id));
    }


    @Override
    public Optional<OtCabecera> get(String email) {

        return null;
    }

    @Override
    public List<OtCabecera> getAll() {
        List<OtCabecera> allOtCabeceras;
        allOtCabeceras = entityManager.createQuery("from OtCabecera", OtCabecera.class).getResultList();
        return allOtCabeceras;
    }

    @Override
    public List<OtCabecera> getAll(int id) {
        return null;
    }

    @Override
    public void save(OtCabecera otCabecera) {
        execute(entityManager -> entityManager.persist(otCabecera));

    }

    @Override
    public void update(OtCabecera otCabecera) {
        execute(entityManager -> entityManager.merge(otCabecera));

    }

    @Override
    public void delete(OtCabecera otCabecera) {
        execute(entityManager -> entityManager.remove(otCabecera));
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
