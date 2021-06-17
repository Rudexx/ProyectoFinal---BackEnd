package edu.unbosque.ProyectoFinal_backend.jpa.Repositories;



import edu.unbosque.ProyectoFinal_backend.jpa.entities.Owner;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Vet;

import javax.persistence.EntityManager;
import java.util.Optional;

public class VetRepositoryImpl implements VetRepository {

    private EntityManager entityManager;

    public VetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Vet> save(Vet vet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vet);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Vet> update(String username, String address, String neighbourhood) {
        try {
            Vet a = entityManager.find(Vet.class, username);
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
}
