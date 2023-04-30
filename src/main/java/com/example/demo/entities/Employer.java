package com.example.demo.entities;

import com.example.demo.entities.enums.Sexe;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Employer")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class Employer  extends Personne {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id_employer", nullable = false)
//    private Long idEmployer;


    @Column
    public Date DateEmbauche;
    @Column
    public int NbJourCongeTotale;
    @Column
    public int NbJourCongeRestant;
    @Column
    public float Salaire;

    @ManyToMany
    @JoinColumn(name="id_services")
    public Set<Service> services;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="id_department")
    public Department department;

    @OneToMany(mappedBy = "employer")
    @JsonManagedReference
    public Set<DemandeConger> demandeConger;

    @OneToMany(mappedBy = "employer")
    @JsonManagedReference
    private Set<DemandeStockable> demandeStockable;



    public Employer(Department department, Set<DemandeConger> demandeConger, Set<DemandeStockable> demandeStockable, Set<Service> services, String cin, String nom, String prenom, Date naissance, Sexe sexe, String adresse, String password, String email, String telephone, int age, Date DateEmbauche, int NbJourCongeTotale, int NbJourCongeRestant, float Salaire) {
        super(cin, nom, prenom, naissance, sexe, adresse, password, email, telephone, age);
        this.department = department;
        this.demandeConger = demandeConger;
        this.demandeStockable = demandeStockable;
        this.services = services;
        this.Salaire = Salaire;
        this.DateEmbauche = DateEmbauche;
        this.NbJourCongeTotale = NbJourCongeTotale;
        this.NbJourCongeRestant = NbJourCongeRestant;
    }
    public Employer(Department department, String cin, String nom, String prenom, Date naissance, Sexe sexe, String adresse, String password, String email, String telephone, int age, Date DateEmbauche, int NbJourCongeTotale, int NbJourCongeRestant, float Salaire) {
        super(cin, nom, prenom, naissance, sexe, adresse, password, email, telephone, age);
        this.department = department;
        this.demandeConger = new HashSet<>();
        this.demandeStockable = new HashSet<>();
        this.services = new HashSet<>();
        this.Salaire = Salaire;
        this.DateEmbauche = DateEmbauche;
        this.NbJourCongeTotale = NbJourCongeTotale;
        this.NbJourCongeRestant = NbJourCongeRestant;
    }

    public Employer() {
    }

    public void addDemandeStockable(DemandeStockable demandeStockable) {
        this.demandeStockable.add(demandeStockable);

    }

    public void addDemandeConger(DemandeConger demandeConger) {
        this.demandeConger.add(demandeConger);

    }

    public void addservice(Service service) {
        this.services.add(service);

    }
}
