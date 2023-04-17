package org.carworkshop.daos;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.CabeceraDiagnostico;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class CabeceraDiagnosticoDao implements Dao<CabeceraDiagnostico> {


    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public CabeceraDiagnosticoDao() {

    }


    @Override
    public Optional<CabeceraDiagnostico> get(int id) {
        return Optional.ofNullable(entityManager.find(CabeceraDiagnostico.class, id));
    }

    @Override
    public Optional<CabeceraDiagnostico> get(String email){

        return Optional.ofNullable(entityManager.createQuery("select c from cabecera_diagnostico c where c.email = :em", CabeceraDiagnostico.class)
                .setParameter("em", email)
                .getResultStream().findFirst().orElse(null));

    }

    @Override
    public List<CabeceraDiagnostico> getAll() {
        List<CabeceraDiagnostico> allUsers;
        allUsers = entityManager.createQuery("Select c from cabecera_diagnostico c", CabeceraDiagnostico.class).getResultList();
        return allUsers;

    }

    @Override
    public List<CabeceraDiagnostico> getAll(int id) {
        return null;
    }

    @Override
    public void save(CabeceraDiagnostico CabeceraDiagnostico) {
        execute(entityManager -> entityManager.persist(CabeceraDiagnostico));

    }

    @Override
    public void update(CabeceraDiagnostico CabeceraDiagnostico) {
        execute(entityManager -> entityManager.merge(CabeceraDiagnostico));

    }

    @Override
    public void delete(CabeceraDiagnostico CabeceraDiagnostico) {
        execute(entityManager -> entityManager.remove(CabeceraDiagnostico));
    }

    private void execute(Consumer<EntityManager> action) throws RuntimeException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        action.accept(entityManager);
        tx.commit();
    }
}