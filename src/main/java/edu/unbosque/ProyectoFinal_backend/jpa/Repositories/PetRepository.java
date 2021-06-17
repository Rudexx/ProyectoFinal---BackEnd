package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;


import edu.unbosque.ProyectoFinal_backend.jpa.entities.Pet;


import java.util.List;
import java.util.Optional;

public interface PetRepository {

    Optional<Pet> save(String username, Pet pet);

    Optional<Pet> update(String username, int petId, String microchip, String species, String race, String size, String sex, String picture, String name);

    List<Pet> findAllPets();

    public List<Pet> findbyUsername(String username);


}
