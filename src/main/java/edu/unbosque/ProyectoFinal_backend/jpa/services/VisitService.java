package edu.unbosque.ProyectoFinal_backend.jpa.services;

import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.VisitRepository;
import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.VisitRepositoryImpl;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.PetCase;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Visit;
import resources.pojos.VisitPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class VisitService {

    VisitRepository visitRepository;

    public Optional<VisitPOJO> createVisit(String username, Integer petId, String created_at, String type, String description) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);


        Optional<Visit> persistedVisit = visitRepository.save(new Visit(created_at,  type,  description));

        entityManager.close();
        entityManagerFactory.close();

        if (persistedVisit.isPresent()) {
            return Optional.of(new VisitPOJO());
        } else {
            return Optional.empty();
        }

    }



}
