package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;



import edu.unbosque.ProyectoFinal_backend.jpa.entities.Owner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OwnerRepositoryImpl implements OwnerRepository {

    private EntityManager entityManager;

    public OwnerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Owner> save(Owner owner) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(owner);
            entityManager.getTransaction().commit();
            return Optional.of(owner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Owner> update(String username, String address, String neighbourhood) {

        try {
            Owner a = entityManager.find(Owner.class, username);
            entityManager.getTransaction().begin();
            a.setAddress(address);
            a.setNeighborhood(neighbourhood);
            entityManager.getTransaction().commit();
            return Optional.of(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    @Override
    public List<Owner> findAllOwners() {
        return entityManager.createQuery("from Owner").getResultList();
    }




}
