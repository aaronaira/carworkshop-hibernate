package org.carworkshop.daos;

import org.carworkshop.entities.Login;
import org.carworkshop.entities.Sesion;
import org.carworkshop.interfaces.Dao;

import jakarta.persistence.*;
import org.hibernate.Hibernate;
import org.hibernate.Internal;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.descriptor.jdbc.IntegerJdbcType;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class SesionDao implements Dao<Sesion>{

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public SesionDao() {

    }


    public Optional <Sesion> get(int id) {
        return entityManager.createQuery("FROM Sesion s where s.id_cliente = " + id + " order by s.id desc limit 1", Sesion.class)
                .getResultStream().findFirst();                                                                   //dt_iniciosesion
    }

    @Override
    public Optional<Sesion> get(String email) {
        return Optional.empty();
    }

    @Override
    public List<Sesion> getAll() {
        return null;
    }


    @Override
    public List<Sesion> getAll(int id) {
        List<Sesion> allClients;
        allClients = entityManager.createQuery("from Sesion s where id_cliente = " + id, Sesion.class).getResultList();
        return allClients;
    }

    @Override
    public void save(Sesion sesion) {
        execute(entityManager -> entityManager.persist(sesion));

    }

    @Override
    public void update(Sesion sesion) {
        execute(entityManager -> entityManager.merge(sesion));
    }



    @Override
    public void delete(Sesion sesion) {
        execute(entityManager -> entityManager.remove(sesion));

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
