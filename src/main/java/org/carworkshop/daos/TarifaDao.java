package org.carworkshop.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.Cita;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Tarifa;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class TarifaDao implements Dao<Tarifa> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public TarifaDao() {

    }


    @Override
    public Optional<Tarifa> get(int id) {
        return Optional.ofNullable(entityManager.find(Tarifa.class, id));
    }

    @Override
    public Optional<Tarifa> get(String email){

        return null;

    }

    @Override
    public List<Tarifa> getAll() {
        List<Tarifa> allTaxes;
        allTaxes = entityManager.createQuery("from Tarifa", Tarifa.class).getResultList();
        return allTaxes;

    }

    @Override
    public List<Tarifa> getAll(int id) {
        return null;
    }

    @Override
    public void save(Tarifa tarifa) {
        execute(entityManager -> entityManager.persist(tarifa));

    }

    @Override
    public void update(Tarifa tarifa) {
        execute(entityManager -> entityManager.merge(tarifa));

    }

    @Override
    public void delete(Tarifa tarifa) {
        execute(entityManager -> entityManager.remove(tarifa));
    }

    private void execute(Consumer<EntityManager> action) throws RuntimeException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        action.accept(entityManager);
        tx.commit();
    }

}
