package com.example.demo.entities;

import com.example.demo.entities.enums.Sexe;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class Personne implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(length = 100)
    public String cin;
    @Column(length = 100)
    public String nom;
    @Column(length = 100)
    public String prenom;

    @Column
    public Date naissance;

    
    @Column
    public Sexe sexe;
    @Column(length = 500)
    public String adresse ;
    @Column(length = 100)
    public String password;
    @Column(length = 100)
    public String email;
    @Column(length = 100)
    public String telephone;
    @Column
    public int age;

    public Personne() {

    }
    public Personne(String cin, String nom, String prenom, Date naissance, Sexe sexe, String adresse, String password, String email, String telephone, int age) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.sexe = sexe;
        this.adresse = adresse;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.age = age;
    }





}
