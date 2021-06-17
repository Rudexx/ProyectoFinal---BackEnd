package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;


import edu.unbosque.ProyectoFinal_backend.jpa.entities.UserApp;

import java.util.Optional;

public interface UserAppRepository {

    Optional<UserApp> findByUsername(String username);

    Optional<UserApp> save(UserApp user);

}
