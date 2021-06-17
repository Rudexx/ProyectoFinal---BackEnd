package edu.unbosque.ProyectoFinal_backend.jpa.services;


import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.OwnerRepositoryImpl;
import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.UserAppRepository;
import edu.unbosque.ProyectoFinal_backend.jpa.Repositories.UserAppRepositoryImpl;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Owner;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.UserApp;
import resources.pojos.OwnerPOJO;
import resources.pojos.UserAppPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class UserAppService {

    UserAppRepository userAppRepository;
/*/
 Bean Validation es establecer un estándar para la definición e implementación de restricciones en clases Java del tipo “el atributo nombre no puede ser nulo
 */
    public Optional<String> validateUser( String username, String password ) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /*/
         Obteniendo credenciales de la base de datos
         */
        userAppRepository = new UserAppRepositoryImpl(entityManager);
        Optional<UserApp> user = userAppRepository.findByUsername(username);

        entityManager.close();
        entityManagerFactory.close();

        /*/
        Validar si las credenciales proporcionadas por el usuario son válidas
        Si tiene éxito, devuelva el rol de usuario
         */
        if (user.isPresent()) {
            if (user.get().getUsername().equals(username) && user.get().getPassword().equals(password)) {
                return Optional.of(user.get().getRole());
            }
        }

        return Optional.empty();

    }

    public String getUsers( String username) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /*/
        Obteniendo credenciales de la base de datos
         */
        userAppRepository = new UserAppRepositoryImpl(entityManager);
        Optional<UserApp> user = userAppRepository.findByUsername(username);


        entityManager.close();
        entityManagerFactory.close();

        /*/
         Validar si las credenciales proporcionadas por el usuario son válidas
         Si tiene éxito, devuelva el rol de usuario
         */

        if (user.isPresent()) {
            return "present";
        }else {

            return "";
        }
    }

    public UserApp getUser( String username, String password ) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        userAppRepository = new UserAppRepositoryImpl(entityManager);
        UserApp user = userAppRepository.findByUsername(username).get();

        entityManager.close();
        entityManagerFactory.close();


        return user;


    }
        /*/
        Un Optional es una clase que puede o no contener un valor, es decir, que se comporta como un wrapper para cualquier tipo de objeto que pueda o no ser nulo
         */
    public Optional<UserAppPOJO> create( String username, String password, String email,String role  ) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppRepositoryImpl(entityManager);


        Optional<UserApp> persistedUserApp = userAppRepository.save(new UserApp(username, password, email, role));

        entityManager.close();
        entityManagerFactory.close();

        if (persistedUserApp.isPresent()) {
            return Optional.of(new UserAppPOJO());
        } else {
            return Optional.empty();
        }

    }

}
