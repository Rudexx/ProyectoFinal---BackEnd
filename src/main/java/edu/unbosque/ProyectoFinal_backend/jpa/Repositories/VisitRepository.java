package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;




import edu.unbosque.ProyectoFinal_backend.jpa.entities.Pet;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Visit;

import java.util.List;
import java.util.Optional;

public interface VisitRepository {

    Optional<Visit> save(Visit visit, String username, Integer petid);

    public List<Visit> findbyVeterinary(String username);

    public List<Visit> findbyPet(int petid);
}
