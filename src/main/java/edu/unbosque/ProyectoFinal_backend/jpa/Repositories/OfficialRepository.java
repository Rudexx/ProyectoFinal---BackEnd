package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;


import edu.unbosque.ProyectoFinal_backend.jpa.entities.Official;

import java.util.Optional;

public interface OfficialRepository {

    Optional<Official> save(Official official);



}
