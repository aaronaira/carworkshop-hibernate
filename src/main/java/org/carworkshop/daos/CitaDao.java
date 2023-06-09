package org.carworkshop.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.Cita;
import org.carworkshop.entities.Vehiculo;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CitaDao implements Dao<Cita> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public CitaDao () {

    }

    @Override
    public Optional<Cita> get(int id) {
        return Optional.ofNullable(entityManager.find(Cita.class, id));
    }



    public Optional<Cita> get(Vehiculo idVehiculo) {

        return Optional.ofNullable(entityManager.createQuery("from Cita c where c.idVehiculo = :idVehiculo", Cita.class)
                .setParameter("idVehiculo", idVehiculo)
                .getResultStream()
                .findFirst().orElse(null));
    }


    @Override
    public List<Cita> getAll() {
        List<Cita> allAppointments;
        allAppointments = entityManager.createQuery("from Cita", Cita.class).getResultList();
        return allAppointments;
    }

    public Optional<List<Cita>> getAll(int idCliente) {
        return Optional.ofNullable(entityManager.createQuery("from Cita c where c.idCliente = " + idCliente, Cita.class)
                .getResultList());

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
