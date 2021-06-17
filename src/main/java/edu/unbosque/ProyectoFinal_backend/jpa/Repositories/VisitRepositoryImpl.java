package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;


import edu.unbosque.ProyectoFinal_backend.jpa.entities.Pet;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Vet;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.util.List;
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

            pet.addVisit(visit);
            vet.addVisit(visit);
            visit.setPet(pet);
            visit.setVet(vet);

            entityManager.persist(visit);
            entityManager.getTransaction().commit();
            return Optional.of(visit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Visit> findbyVeterinary(String username) {
        return entityManager.createQuery(
                "SELECT c FROM Visit c WHERE c.vet.user.username LIKE :username")
                .setParameter("username", username)
                .getResultList();
    }

    @Override
    public List<Visit> findbyPet(int petid) {
        return entityManager.createQuery(
                "SELECT c FROM Visit c WHERE c.pet.pet_id =" + petid)
                .getResultList();
    }


}
