package org.carworkshop.daos;




import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.carworkshop.entities.Vehiculo;
import org.carworkshop.interfaces.Dao;

public class VehiculoDao implements Dao<Vehiculo>  {


    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public VehiculoDao () {

    }


    @Override
    public Optional<Vehiculo> get(int id) {
        return Optional.ofNullable(entityManager.find(Vehiculo.class, id));
    }


    @Override
    public Optional<Vehiculo> get(String email) {

        return Optional.ofNullable(entityManager
                .createQuery("from Vehiculo v where v.id_cliente = :email", Vehiculo.class)
                .setParameter("email", email)
                .getResultStream().findFirst().orElse(null));
    }


    @Override
    public List<Vehiculo> getAll() {
        List<Vehiculo> allUsers;
        allUsers = entityManager.createQuery("from Vehiculo", Vehiculo.class).getResultList();
        return allUsers;

    }

    @Override
    public List<Vehiculo> getAll(int id) {
        return null;
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