package org.carworkshop.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.carworkshop.entities.CabeceraDiagnostico;
import org.carworkshop.entities.LineaDiagnostico;
import org.carworkshop.entities.LineaDiagnosticoPK;
import org.carworkshop.interfaces.Dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class LineaDiagnosticoDao implements Dao<LineaDiagnostico> {


    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.carworkshop");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public LineaDiagnosticoDao() {

    }
    @Override
    public Optional<LineaDiagnostico> get(int id) {
        return Optional.ofNullable(entityManager.find(LineaDiagnostico.class, id));
    }
//    public Optional<LineaDiagnosticoPK> get(int id, int n_linea) {
//        return Optional.ofNullable(entityManager.find(LineaDiagnosticoPK.class, new LineaDiagnosticoPK(id, n_linea)));
//    }
    public Optional<LineaDiagnostico> get(LineaDiagnosticoPK ldpk) {
    return Optional.ofNullable(entityManager.find(LineaDiagnostico.class, ldpk));
}
    @Override
    public Optional<LineaDiagnostico> get(String email){

//        return Optional.ofNullable(entityManager.createQuery("select c from LineaDiagnostico c where c.email = :em", LineaDiagnostico.class)
//                .setParameter("em", email)
//                .getResultStream().findFirst().orElse(null));
        return null;
    }

    public Optional<LineaDiagnosticoPK> get(int id, int n_linea){

        return Optional.ofNullable(entityManager.createQuery("select c from LineaDiagnostico c where c.iddiagnostico = "+id+" and c.nlinea = "+n_linea, LineaDiagnosticoPK.class)
                .getResultStream().findFirst().orElse(null));

    }

    @Override
    public List<LineaDiagnostico> getAll() {
        List<LineaDiagnostico> allDiagnostics;
        allDiagnostics = Optional.of(entityManager.createQuery("Select c from LineaDiagnostico c", LineaDiagnostico.class))
                .get().getResultList();
        return allDiagnostics;

    }

    @Override
    public List<LineaDiagnostico> getAll(int id) {
        return null;
    }

    @Override
    public void save(LineaDiagnostico lineaDiagnostico) {
        execute(entityManager -> entityManager.persist(lineaDiagnostico));

    }

    @Override
    public void update(LineaDiagnostico lineaDiagnostico) {
        execute(entityManager -> entityManager.merge(lineaDiagnostico));

    }

    @Override
    public void delete(LineaDiagnostico lineaDiagnostico) {
        execute(entityManager -> entityManager.remove(lineaDiagnostico));
    }

    private void execute(Consumer<EntityManager> action) throws RuntimeException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        action.accept(entityManager);
        tx.commit();
    }
}
