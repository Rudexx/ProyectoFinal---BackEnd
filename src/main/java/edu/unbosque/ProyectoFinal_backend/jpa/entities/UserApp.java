package edu.unbosque.ProyectoFinal_backend.jpa.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="UserApp")

public class UserApp {
   @OneToOne(mappedBy = "user")
    Vet vet;

   @OneToOne(mappedBy = "user")
   Official official;

   @OneToOne(mappedBy = "user")
    Owner owner;

    @Id
    @Column(name="username")
     String username;

    @Column(name="password")
    String password;

    @Column(name="email")
    String email;

    @Column(name="role")
    String role;

    public UserApp(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public UserApp() {
    }

    @Override
    public String toString() {
        return "UserApp{" +
                "vet=" + vet +
                ", official=" + official +
                ", owner=" + owner +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Official getOfficial() {
        return official;
    }

    public void setOfficial(Official official) {
        this.official = official;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


