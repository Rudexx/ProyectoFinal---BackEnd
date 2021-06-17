package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;



import edu.unbosque.ProyectoFinal_backend.jpa.entities.Pet;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.PetCase;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetCaseRepositoryImpl implements PetCaseRepository {

    private EntityManager entityManager;

    public PetCaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Este metodo crea un caso sobre una mascota, siendo especifico en la fecha de creacion, usuario que registra
     * y la descripcion sobre el tipo de caso
     * @param username es el nombre de usuario de la persona que esta haciendo la creacion del caso
     * @param petId es la ID que tiene la mascota a la que se le asignara el caso
     * @param created_at es la fecha de creacion del caso
     * @param type es el tipo de caso que se esta registrando, pudiendo ser perdida, robo, esterilizacion, etc
     * @param description es la descripcion especifica sobre el caso que se esta queriendo registrar
     * @return retorna un Optional vacio o conteniendo algo dependiendo si el caso fue creado con exito
     */
    @Override
    public Optional<PetCase> save(String username, Integer petId, String created_at, String type, String description) {

        try {
            entityManager.getTransaction().begin();
            Pet pet = entityManager.find(Pet.class, petId);
            PetCase Pcase = new PetCase(created_at,type,description);
            pet.addCase(Pcase);
            Pcase.setPet(pet);
            entityManager.persist(Pcase);
            entityManager.getTransaction().commit();
            return Optional.of(Pcase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * Este metodo busca las mascotas de un usuario usando su ID
     * @param username se le envia el username del usuario con el cual se buscaran todas las mascotas asociadas a el
     * @return se retornara una lista con todas las mascotas del usuario que se envio
     */
    @Override
    public List<PetCase> findbyPetId(String username) {

        return entityManager.createQuery(
                "SELECT c FROM PetCase c WHERE c.pet.owner.user.username LIKE :username").
                setParameter("username", username)
                .getResultList();
    }
}
