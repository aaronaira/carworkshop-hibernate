package org.carworkshop.daos;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Empleado;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class EmpleadoDao implements Dao<Empleado> {


    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public EmpleadoDao() {

    }


    @Override
    public Optional<Empleado> get(int id) {
        return Optional.ofNullable(entityManager.find(Empleado.class, id));
    }


    public Optional<Empleado> get(String email){

        return Optional.ofNullable(entityManager.createQuery("select c from Empleado c where c.email = :em", Empleado.class)
                .setParameter("em", email)
                .getResultStream().findFirst().orElse(null));

    }

    @Override
    public List<Empleado> getAll() {
        List<Empleado> allEmployees;
        allEmployees = entityManager.createQuery("from Empleado", Empleado.class).getResultList();
        return allEmployees;

    }


    @Override
    public void save(Empleado empleado) {
        execute(entityManager -> entityManager.persist(empleado));

    }

    @Override
    public void update(Empleado empleado) {
        execute(entityManager -> entityManager.merge(empleado));

    }

    @Override
    public void delete(Empleado empleado) {
        execute(entityManager -> entityManager.remove(empleado));
    }

    private void execute(Consumer<EntityManager> action) throws RuntimeException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        action.accept(entityManager);
        tx.commit();
    }
}
