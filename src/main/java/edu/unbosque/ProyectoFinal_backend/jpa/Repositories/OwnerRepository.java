package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;



import edu.unbosque.ProyectoFinal_backend.jpa.entities.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

    Optional<Owner> save(Owner owner);

    Optional<Owner> update(String username, String address, String neighbourhood);

    List<Owner> findAllOwners();


}
