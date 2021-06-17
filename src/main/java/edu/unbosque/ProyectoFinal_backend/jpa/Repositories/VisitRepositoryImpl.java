package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;


import edu.unbosque.ProyectoFinal_backend.jpa.entities.Pet;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Vet;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.util.Optional;

public class VisitRepositoryImpl implements VisitRepository {

    private EntityManager entityManager;

    public VisitRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Visit> save(Visit visit, String username, Integer petid) {
        try {
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petid);
            Vet vet = entityManager.find(Vet.class, username);



            entityManager.persist(visit);
            entityManager.getTransaction().commit();
            return Optional.of(visit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
