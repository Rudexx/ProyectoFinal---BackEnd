package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;


import edu.unbosque.ProyectoFinal_backend.jpa.entities.UserApp;

import javax.persistence.EntityManager;
import java.util.Optional;

public class UserAppRepositoryImpl implements UserAppRepository {
/*/
    La entity manager es capaz de trabajar con entidades gestionadas (Managed).
 */
    private EntityManager entityManager;

    public UserAppRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
/*/
    El Override que se utuliza para sobre escribir metodos virtuales o implementar metodos ya sean abatractos

 */
    @Override
    public Optional<UserApp> findByUsername(String username) {
        UserApp user = entityManager.find(UserApp.class, username);
        return user != null ? Optional.of(user) : Optional.empty();
    }

    /*/
    El save lo que hace es guardar de manera alterar la base de datos que se esta manejando
    Transaction es el API mediante el cual es posible controlar las transacciones de una aplicación
    Hace persistente una instancia transitoria. Sin embargo
     */

    @Override

    public Optional<UserApp> save(UserApp user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
