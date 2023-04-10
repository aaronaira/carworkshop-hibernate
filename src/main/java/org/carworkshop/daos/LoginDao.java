package org.carworkshop.daos;




import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import jakarta.transaction.Transactional;
import org.carworkshop.entities.Login;
import org.carworkshop.interfaces.Dao;

public class LoginDao implements Dao<Login>  {


    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public LoginDao () {

    }


    @Override
    public Optional<Login> get(int id) {
        return Optional.ofNullable(entityManager.find(Login.class, id));
    }


    @Override
    public Optional<Login> get(String email) {

        return Optional.ofNullable(entityManager
                .createQuery("from Login l where email = :email", Login.class)
                .setParameter("email", email)
                .getResultStream().findFirst().orElse(null));
    }


    @Override
    public List<Login> getAll() {
        List<Login> allUsers;
        allUsers = entityManager.createQuery("from Login", Login.class).getResultList();
        return allUsers;

    }

    @Override
    public List<Login> getAll(int id) {
        return null;
    }

    @Override
    public void save(Login login) {
        execute(entityManager -> entityManager.persist(login));

    }

    @Override
    @Transactional
    public void update(Login login) {
        execute(entityManager -> entityManager.merge(login));

    }

    @Override
    public void delete(Login login) {
        execute(entityManager -> entityManager.remove(login));
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