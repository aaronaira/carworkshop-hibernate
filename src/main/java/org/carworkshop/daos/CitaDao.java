package org.carworkshop.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.Cita;
import org.carworkshop.entities.Cliente;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class CitaDao implements Dao<Cita> {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    public CitaDao() {

    }
    @Override
    public Optional<Cita> get(int id) {

        return Optional.ofNullable(entityManager.find(Cita.class, id));
    }

    @Override
    public Optional<Cita> get(String email){

        return null;

    }

    @Override
    public List<Cita> getAll() {

        List<Cita> allAppointments;
        allAppointments = entityManager.createQuery("from Cita", Cita.class).getResultList();
        return allAppointments;

    }
    @Override
    public List<Cita> getAll(int id) {
        return null;
    }

    @Override
    public void save(Cita cita) {
        execute(entityManager -> entityManager.persist(cita));

    }

    @Override
    public void update(Cita cita) {
        execute(entityManager -> entityManager.merge(cita));

    }

    @Override
    public void delete(Cita cita) {
        execute(entityManager -> entityManager.remove(cita));
    }

    public Optional<Cita> getAllAppointments(int id_cliente) {
        return Optional.ofNullable(entityManager.createQuery("select c from Cita c where c.id_cliente = :idc", Cita.class)
                .setParameter("idc", id_cliente)
                .getResultStream().findAny().orElse(null));
    }
    private void execute(Consumer<EntityManager> action) throws RuntimeException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        action.accept(entityManager);
        tx.commit();
    }
}

