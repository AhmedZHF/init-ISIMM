package com.example.demo.gestionConge.exempleEntity;

import java.util.Date;

import com.example.demo.entities.DemandeConger;
import com.example.demo.entities.enums.Cause;
import com.example.demo.entities.enums.Etat;



public class Demande {
	private Long idDem ;
    private Cause type;
    private String Justification;
    private Date DateDebut;
    private Date DateFin;
    private Etat etatDemande;
    private Long idEmp;
    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String departement;
    
    
    public Demande() {}
    
    public Demande(DemandeConger dem) {
    	this.idDem=dem.getId();
    	this.idEmp=dem.getEmployer().id;
    	this.DateDebut=dem.getDateDebut();
    	this.DateFin=dem.getDateFin();
    	this.Justification=dem.getJustification();
    	this.nom=dem.getEmployer().nom;
    	this.prenom=dem.getEmployer().prenom;
    	this.email=dem.getEmployer().email;
    	this.departement=dem.getEmployer().department.name;
    	this.telephone=dem.getEmployer().telephone;
    	this.cin=dem.getEmployer().cin;
    	this.type=dem.getType();
    	this.etatDemande=dem.getEtatDemande();
    	
    	
    	
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
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Long getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(Long id) {
		this.idEmp = id;
	}
	public Long getIdDem() {
		return idDem;
	}
	public void setIdDem(Long id) {
		this.idDem = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}
	

}
