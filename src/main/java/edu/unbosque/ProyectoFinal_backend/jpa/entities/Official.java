package edu.unbosque.ProyectoFinal_backend.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Official")
@PrimaryKeyJoinColumn
public class Official implements Serializable {
    @OneToOne(cascade =CascadeType.ALL)
    @Id
    @JoinColumn(name="username")
    UserApp user;

    @Column(name="name")
    String name;

    public Official(UserApp userapp, String name) {
        this.user = userapp;
        this.name = name;
    }

    public Official() {
    }
}
