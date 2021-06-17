package edu.unbosque.ProyectoFinal_backend.jpa.entities;

import javax.persistence.*;


@Entity
@Table(name="PetCase")
public class PetCase {
    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id")
    Pet pet;

    @Id
    @GeneratedValue
    @Column(name="case_id")
    int Case_id;

    @Column(name="created_at")
    String created_at;

    @Column(name="type")
    String type;

    @Column(name="description")
    String description;



    public PetCase(String created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;

    }

    public PetCase() {
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getCase_id() {
        return Case_id;
    }

    public void setCase_id(int case_id) {
        Case_id = case_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

