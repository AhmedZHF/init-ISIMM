package com.example.demo.Doa;

import com.example.demo.entities.DemandeConger;
import com.example.demo.entities.enums.Etat;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface DemandeCongerRepository extends JpaRepository<DemandeConger, Long> {
	
	 @Query("SELECT s FROM DemandeConger s WHERE s.etatDemande = ?1")
	 List<DemandeConger> findByEtat(@Param("etat") Etat etat);
	 
	 @Query("SELECT s FROM DemandeConger s WHERE s.etatDemande = ACCEPTE")
	 List<DemandeConger> findByEtatAccepte();
	 
	 @Query("SELECT s FROM DemandeConger s WHERE s.etatDemande = REFUSE")
	 List<DemandeConger> findByEtatRefuse();
	 
	 @Query("SELECT s FROM DemandeConger s WHERE s.etatDemande = ATTENTE")
	 List<DemandeConger> findByEtatAttente();
	 
	 
	 
	 
	 
	
	 
	 
	

	


}