package com.example.demo.entities;

import com.example.demo.entities.enums.Cause;
import com.example.demo.entities.enums.Etat;
import com.example.demo.entities.enums.TypeCongé;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Entity
public class DemandeConger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demande_conger", nullable = false)
    private Long idDemandeConger;


    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="id_employer")
    private Employer employer;


    private Cause type;
    
    private String Justification;
    private Date DateDebut;
    private Date DateFin;
    private Etat etatDemande;

    public DemandeConger() {

    }

    public DemandeConger(Employer employer, Cause type, String justification, Date dateDebut, Date dateFin, Etat etatDemande) {
        this.employer = employer;
        this.setType(type);
        this.setJustification(justification);
        this.setDateDebut(dateDebut);
        this.setDateFin(dateFin);
        this.setEtatDemande(etatDemande);
    }
    
    public Long getId() {
		return idDemandeConger;
	}

	public void setId(Long idDemandeConger) {
		this.idDemandeConger = idDemandeConger;
	} 
   
	
	public Cause getType() {
		return type;
	}

	public void setType(Cause type) {
		this.type = type;
	}

	public String getJustification() {
		return Justification;
	}

	public void setJustification(String justification) {
		Justification = justification;
	}

	public Date getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}

	public Etat getEtatDemande() {
		return etatDemande;
	}

	public void setEtatDemande(Etat etatDemande) {
		this.etatDemande = etatDemande;
	}

	public Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}
	
	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer emp) {
		employer = emp;
	}


  
}
