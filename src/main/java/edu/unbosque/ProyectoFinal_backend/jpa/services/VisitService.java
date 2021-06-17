package edu.unbosque.ProyectoFinal_backend.jpa.services;

import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.PetRepositoryImpl;
import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.VisitRepository;
import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.VisitRepositoryImpl;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Pet;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.PetCase;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Visit;
import resources.pojos.PetPOJO;
import resources.pojos.VisitPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class VisitService {

    VisitRepository visitRepository;

    public Optional<VisitPOJO> createVisit(String username, Integer petId, String created_at, String type, String description) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);


        Optional<Visit> persistedVisit = visitRepository.save(new Visit(created_at,  type,  description), username, petId);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedVisit.isPresent()) {
            return Optional.of(new VisitPOJO());
        } else {
            return Optional.empty();
        }

    }

    public List<VisitPOJO> listVisitsByPet(int petid) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        List<Visit> visits = visitRepository.findbyPet(petid);

        entityManager.close();
        entityManagerFactory.close();

        List<VisitPOJO> visitPOJOs = new ArrayList<>();

        for (Visit visit : visits) {
            visitPOJOs.add(new VisitPOJO(visit.getCreate_at(), visit.getType(), visit.getDescription()));
        }
        return visitPOJOs;
    }

    public List<VisitPOJO> listVisitsByVet(String username) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        List<Visit> visits = visitRepository.findbyVeterinary(username);

        entityManager.close();
        entityManagerFactory.close();

        List<VisitPOJO> visitPOJOs = new ArrayList<>();

        for (Visit visit : visits) {
            visitPOJOs.add(new VisitPOJO(visit.getCreate_at(), visit.getType(), visit.getDescription()));
        }
        return visitPOJOs;
    }





}
