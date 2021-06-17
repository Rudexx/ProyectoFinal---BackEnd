package edu.unbosque.ProyectoFinal_backend.jpa.services;


import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.*;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Owner;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Pet;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.UserApp;
import resources.pojos.OwnerPOJO;
import resources.pojos.PetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class PetService {

    PetRepository petRepository;
    OwnerRepository ownerRepository;
    UserAppRepository userAppRepository;

    public List<PetPOJO> listPetsByUsername(String username) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        ownerRepository = new OwnerRepositoryImpl(entityManager);
        userAppRepository = new UserAppRepositoryImpl(entityManager);

        UserApp user = userAppRepository.findByUsername(username).get();
        System.out.println(user.toString());
        List<Pet> pets = new ArrayList<Pet>();
        pets = petRepository.findbyUsername(username);


        entityManager.close();
        entityManagerFactory.close();

        List<PetPOJO> petPOJOs = new ArrayList<>();

        for (Pet pet : pets) {

            petPOJOs.add(new PetPOJO(pet.getMicrochip(), pet.getName(), pet.getSpecies(),
                    pet.getRace(), pet.getSize(), pet.getSex(), pet.getSize()));
        }
        return petPOJOs;
    }

    public List<PetPOJO> listPets() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        List<Pet> pets = petRepository.findAllPets();

        entityManager.close();
        entityManagerFactory.close();

        List<PetPOJO> petPOJOs = new ArrayList<>();

        for (Pet pet : pets) {
            petPOJOs.add(new PetPOJO(pet.getMicrochip(), pet.getName(), pet.getSpecies(),
                    pet.getRace(), pet.getSize(), pet.getSex(), pet.getSize()));
        }
        return petPOJOs;
    }

    public Optional<PetPOJO> createPet(String username,String microchip, String species, String race, String size, String sex, String picture, String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);


        Optional<Pet> persistedPet = petRepository.save(username,new Pet(microchip, species, race, size, sex, picture, name));

        entityManager.close();
        entityManagerFactory.close();

        if (persistedPet.isPresent()) {
            return Optional.of(new PetPOJO());
        } else {
            return Optional.empty();
        }

    }

    public Optional<PetPOJO> updatePet(String username,int petId, String microchip, String species, String race, String size, String sex, String picture, String name) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);


        Optional<Pet> updatedPet = petRepository.update(username,petId,microchip,  species,  race,  size,  sex,  picture,name);

        entityManager.close();
        entityManagerFactory.close();

        if (updatedPet.isPresent()) {
            return Optional.of(new PetPOJO());
        } else {
            return Optional.empty();
        }

    }

}
