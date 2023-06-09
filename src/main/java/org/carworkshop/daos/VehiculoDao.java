package org.carworkshop.daos;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.Vehiculo;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class VehiculoDao implements Dao<Vehiculo> {


    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public VehiculoDao() {

    }


    @Override
    public Optional<Vehiculo> get(int id) {
        return Optional.ofNullable(entityManager.find(Vehiculo.class, id));
    }


    public Optional<Vehiculo> get(String email){
        return Optional.ofNullable(entityManager.createQuery("Select c from Vehiculo c where c.matricula = :email", Vehiculo.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst().orElse(null));

    }

    @Override
    public List<Vehiculo> getAll() {
        List<Vehiculo> allUsers;
        allUsers = entityManager.createQuery("from Vehiculo", Vehiculo.class).getResultList();
        return allUsers;

    }


    @Override
    public void save(Vehiculo vehiculo) {
        execute(entityManager -> entityManager.persist(vehiculo));

    }

    @Override
    public void update(Vehiculo vehiculo) {
        execute(entityManager -> entityManager.merge(vehiculo));

    }

    @Override
    public void delete(Vehiculo vehiculo) {
        execute(entityManager -> entityManager.remove(vehiculo));
    }

    private void execute(Consumer<EntityManager> action) throws RuntimeException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        action.accept(entityManager);
        tx.commit();
    }
}