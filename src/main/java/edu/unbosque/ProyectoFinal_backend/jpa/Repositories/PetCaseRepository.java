package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;




import edu.unbosque.ProyectoFinal_backend.jpa.entities.Pet;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.PetCase;

import java.util.List;
import java.util.Optional;

public interface PetCaseRepository {

    Optional<PetCase> save(String username, Integer petId, String created_at, String type, String description);

    public List<PetCase> findbyPetId(String username);
}
