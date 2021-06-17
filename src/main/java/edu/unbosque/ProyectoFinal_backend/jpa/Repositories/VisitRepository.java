package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;




import edu.unbosque.ProyectoFinal_backend.jpa.entities.Visit;

import java.util.Optional;

public interface VisitRepository {

    Optional<Visit> save(Visit visit);
}
