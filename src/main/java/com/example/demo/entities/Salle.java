package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Salle")
@Getter
@Setter
public class Salle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_salle", nullable = false)
    private Long idSalle;


    @Column
    private Boolean disponibilité;

    @OneToMany(mappedBy = "salle",fetch=FetchType.LAZY)
    private Set<Seance> seances;

    public Salle(Boolean disponibilité, Set<Seance> seances) {
        this.disponibilité = disponibilité;
        this.seances = seances;
    }

    public Salle(Boolean disponibilité ) {
        this.disponibilité = disponibilité;
    }

    public Salle() {
    }


    public void addSeance(Seance seance) {
        this.seances.add(seance);
        //seance.setSalle(this);
    }





}
