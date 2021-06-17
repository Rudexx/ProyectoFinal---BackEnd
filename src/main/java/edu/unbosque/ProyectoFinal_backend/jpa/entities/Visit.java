package edu.unbosque.ProyectoFinal_backend.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name="Visit")


public class Visit {
    @ManyToOne
    @JoinColumn(name="username")
    Pet pet;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    Vet vet;

    @Id
    @GeneratedValue
    @Column(name="visit_id")
    int visi_id;
    @Column(name="create_at")
    String create_at;

    @Column(name="type")
    String type;

    @Column(name="description")
    String description;





    public Visit(String create_at, String type, String description) {

        this.create_at = create_at;
        this.type = type;
        this.description = description;
    }

    public Visit() {
    }
}
