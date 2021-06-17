package edu.unbosque.ProyectoFinal_backend.jpa.services;


import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.OwnerRepository;
import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.OwnerRepositoryImpl;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Owner;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.UserApp;
import resources.pojos.OwnerPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class OwnerService {

    OwnerRepository ownerRepository;

    public Optional<OwnerPOJO> createOwner(String name , String address , String neighbourhood, UserApp user) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);


        Optional<Owner> persistedOwner = ownerRepository.save(new Owner(user, name, address, neighbourhood));

        entityManager.close();
        entityManagerFactory.close();

        if (persistedOwner.isPresent()) {
            return Optional.of(new OwnerPOJO());
        } else {
            return Optional.empty();
        }

    }

    public Optional<Owner> updateOwner(String username,String address, String neighbourhood) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);


        Optional<Owner> persistedOwner = ownerRepository.update(username, address, neighbourhood);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedOwner.isPresent()) {
            return Optional.of(new Owner());
        } else {
            return Optional.empty();
        }

    }

    public List<OwnerPOJO> listOwners() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        List<Owner> owners = ownerRepository.findAllOwners();

        entityManager.close();
        entityManagerFactory.close();

        List<OwnerPOJO> ownersPOJO = new ArrayList<>();

        for (Owner owner : owners) {
            ownersPOJO.add(new OwnerPOJO(owner.getPerson_id(),
                    owner.getName(), owner.getAddress(),
                    owner.getNeighborhood()));
        }
        return ownersPOJO;
    }

}
