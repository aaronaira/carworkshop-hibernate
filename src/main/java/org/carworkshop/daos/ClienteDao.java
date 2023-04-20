package org.carworkshop.daos;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.Cliente;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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

        return Optional.ofNullable(entityManager.createQuery("select c from Cliente c where c.email = :em", Cliente.class)
                        .setParameter("em", email)
                .getResultStream().findFirst().orElse(null));

    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> allUsers;
        allUsers = entityManager.createQuery("from Cliente", Cliente.class).getResultList();
        return allUsers;

    }

    @Override
    public List<Cliente> getAll(int id) {
        return null;
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

    private void execute(Consumer<EntityManager> action) throws RuntimeException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        action.accept(entityManager);
        tx.commit();
    }
}