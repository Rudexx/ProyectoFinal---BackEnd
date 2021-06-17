package edu.unbosque.ProyectoFinal_backend.jpa.services;

import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.OfficialRepositoryImpl;
import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.VetRepositoryImpl;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Official;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.UserApp;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Vet;
import resources.pojos.OfficialPOJO;
import resources.pojos.VetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class OfficialService {

    OfficialRepositoryImpl officialRepository;

    public Optional<OfficialPOJO> createOfficial(String name , UserApp user) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);


        Optional<Official> persistedOfficial = officialRepository.save(new Official(user,name));

        entityManager.close();
        entityManagerFactory.close();

        if (persistedOfficial.isPresent()) {
            return Optional.of(new OfficialPOJO());
        } else {
            return Optional.empty();
        }

    }



}
