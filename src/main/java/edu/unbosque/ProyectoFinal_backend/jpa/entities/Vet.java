package edu.unbosque.ProyectoFinal_backend.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Vet")
@PrimaryKeyJoinColumn
public class Vet implements Serializable {
    @OneToMany(mappedBy = "vet", cascade = CascadeType.ALL)
    List<Visit> visits = new ArrayList<>();


    @OneToOne(cascade =CascadeType.ALL)
    @Id
    @JoinColumn(name="username")
    UserApp user;

    @Column(name="address")
    String address;

    @Column(name="neighbothood")
    String neighborhood;

    @Column(name="name")
    String name;

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public UserApp getUser() {
        return user;
    }

    public void setUser(UserApp user) {
        this.user = user;
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

    public void setNeighborhood(String neighbothood) {
        this.neighborhood = neighbothood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vet() {
    }

    public Vet( UserApp user, String address, String neighborhood, String name) {

        this.user = user;
        this.address = address;
        this.neighborhood = neighborhood;
        this.name = name;
    }

    public void addVisit(Visit visit){
        visits.add(visit);
    }
}
