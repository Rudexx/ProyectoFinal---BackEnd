package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;


import edu.unbosque.ProyectoFinal_backend.jpa.entities.Official;

import javax.persistence.EntityManager;
import java.util.Optional;

public class OfficialRepositoryImpl implements OfficialRepository {

    private EntityManager entityManager;

    public OfficialRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Official> save(Official official) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(official);
            entityManager.getTransaction().commit();
            return Optional.of(official);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
