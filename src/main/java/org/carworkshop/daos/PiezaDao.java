package org.carworkshop.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Pieza;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class PiezaDao implements Dao<Pieza> {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public PiezaDao() {

    }
    @Override
    public Optional<Pieza> get(int id) {
        return Optional.ofNullable(entityManager.find(Pieza.class, id));
    }

    @Override
    public Optional<Pieza> get(String email) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Pieza> getAll() {
        List<Pieza> allPieces;
        allPieces = entityManager.createQuery("from Piezas", Pieza.class).getResultList();
        return allPieces;

    }

    @Override
    public List<Pieza> getAll(int id) {
        return null;
    }

    @Override
    public void save(Pieza pieza) {
        execute(entityManager -> entityManager.persist(pieza));

    }

    @Override
    public void update(Pieza pieza) {
        execute(entityManager -> entityManager.merge(pieza));

    }

    @Override
    public void delete(Pieza pieza) {
        execute(entityManager -> entityManager.remove(pieza));
    }

    private void execute(Consumer<EntityManager> action) throws RuntimeException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        action.accept(entityManager);
        tx.commit();
    }
}
