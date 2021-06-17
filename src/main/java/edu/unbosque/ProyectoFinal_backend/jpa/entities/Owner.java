package edu.unbosque.ProyectoFinal_backend.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name="Owner")
@PrimaryKeyJoinColumn
public class Owner implements Serializable {


    @Id
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="username")
    UserApp user;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<Pet>();


    @Column(name="person_id", unique = true)
    Integer person_id;

    @Column(name="name")
    String name;

    @Column(name="address")
    String address;

    @Column(name="neighborhood")
    String neighborhood;

    public Owner(UserApp userapp, String name, String address, String neighborhood) {
        this.user = userapp;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
        person_id = new Random().nextInt(1000);
    }

    public Owner() {
    }


    public UserApp getUserapp() {
        return user;
    }

    public void setUserapp(UserApp userapp) {
        this.user = userapp;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void addPet(Pet pet){
        pets.add(pet);
    }

    public List<Pet> getPets() {
        return pets;
    }
}