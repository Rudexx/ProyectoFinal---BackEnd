package edu.unbosque.ProyectoFinal_backend.jpa.services;

import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.*;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Pet;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.PetCase;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.UserApp;
import resources.pojos.PetCasePOJO;
import resources.pojos.PetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class CaseService {

    PetCaseRepository caseRepository;

    public Optional<PetCasePOJO> createCase(String username, Integer petId, String created_at, String type, String description) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        caseRepository = new PetCaseRepositoryImpl(entityManager);


        Optional<PetCase> persistedPetCase = caseRepository.save(username,  petId,  created_at,  type,  description);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedPetCase.isPresent()) {
            return Optional.of(new PetCasePOJO());
        } else {
            return Optional.empty();
        }

    }
    public List<PetCasePOJO> listCasesByPet(String username) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        caseRepository = new PetCaseRepositoryImpl(entityManager);

        List<PetCase> cases = new ArrayList<PetCase>();
        cases = caseRepository.findbyPetId(username);


        entityManager.close();
        entityManagerFactory.close();

        List<PetCasePOJO> petCasePOJOs = new ArrayList<>();

        for (PetCase Petcase : cases) {

            petCasePOJOs.add(new PetCasePOJO(Petcase.getCreated_at(), Petcase.getType(), Petcase.getDescription(),
                    String.valueOf(Petcase.getPet().getPet_id())));
        }
        return petCasePOJOs;
    }




}
