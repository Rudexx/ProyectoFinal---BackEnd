package edu.unbosque.ProyectoFinal_backend.jpa.services;



import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.VetRepositoryImpl;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.UserApp;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Vet;
import resources.pojos.VetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class VetService {

    VetRepositoryImpl vetRepository;

    public Optional<VetPOJO> createVet(String name , String address , String neighbourhood, UserApp user) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);


        Optional<Vet> persistedVet = vetRepository.save(new Vet(user, address, neighbourhood, name));

        entityManager.close();
        entityManagerFactory.close();

        if (persistedVet.isPresent()) {
            return Optional.of(new VetPOJO());
        } else {
            return Optional.empty();
        }

    }

    public Optional<Vet> updateVet(String username,String address, String neighbourhood) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);


        Optional<Vet> updatedVet = vetRepository.update(username, address, neighbourhood);

        entityManager.close();
        entityManagerFactory.close();

        if (updatedVet.isPresent()) {
            return Optional.of(new Vet());
        } else {
            return Optional.empty();
        }

    }

}
