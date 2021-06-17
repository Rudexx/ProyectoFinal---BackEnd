package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;



import edu.unbosque.ProyectoFinal_backend.jpa.entities.Owner;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Vet;

import java.util.Optional;

public interface VetRepository {

    Optional<Vet> save(Vet vet);

    Optional<Vet> update(String username, String address, String neighbourhood);
}
