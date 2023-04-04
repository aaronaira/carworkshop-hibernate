package org.carworkshop.daos;


import org.carworkshop.entities.Login;
import org.carworkshop.interfaces.Dao;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import org.carworkshop.entities.Cliente;

public class ClienteDao implements Dao<Cliente> {


    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public ClienteDao() {

    }


    @Override
    public Optional<Cliente> get(int id) {
        return Optional.ofNullable(entityManager.find(Cliente.class, id));
    }

    @Override
    public Optional<Cliente> get(String email){

        return Optional.ofNullable(entityManager.createQuery("from Cliente c where email = :email", Cliente.class)
                .setParameter("email", email)
                .getResultStream().findFirst().orElse(null));

    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> allUsers;
        allUsers = entityManager.createQuery("from Cliente", Cliente.class).getResultList();
        return allUsers;

    }

    @Override
    public void save(Cliente cliente) {
        execute(entityManager -> entityManager.persist(cliente));

    }

    @Override
    public void update(Cliente cliente) {
        execute(entityManager -> entityManager.merge(cliente));

    }

    @Override
    public void delete(Cliente cliente) {
        execute(entityManager -> entityManager.remove(cliente));
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