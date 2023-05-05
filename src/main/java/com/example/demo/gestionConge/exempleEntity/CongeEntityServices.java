package com.example.demo.gestionConge.exempleEntity;


import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Doa.DemandeCongerRepository;
import com.example.demo.entities.DemandeConger;
import com.example.demo.entities.Employer;
import com.example.demo.entities.enums.Etat;





@Service
@AllArgsConstructor
public class CongeEntityServices {
	@Autowired
	private  DemandeCongerRepository CongerRepository ;


    
    
    public List<Demande> getAllDemande() {
    	
    	List<DemandeConger> L1= CongerRepository.findAll() ;
    	List<Demande> L2 = new ArrayList<Demande>();
    	
    	for (DemandeConger element : L1) {
    	    L2.add(new Demande(element));
    	}
    	
    	
        return L2;
    }
    
    
    
    
    
    public DemandeConger saveDemande(DemandeConger demande) {
        return CongerRepository.save(demande);
    }
    
   
    
    
    public Optional<DemandeConger> getDemande(Long demandeId) {
    	Optional<DemandeConger> demande=Optional.of(CongerRepository.findById(demandeId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " )));
        DemandeConger dem= demande.orElse(new DemandeConger());
        Employer emp=new Employer();
        emp.nom="Ahmed";
        System.out.println(dem.getEmployer().cin);
        
        Demande dem1=new Demande(dem);
        		
    	//System.out.println(demande.get().getEmployer().department.name);
    	return demande;
         
    }
    
public void deleteDemanderById(Long id) {
		
		CongerRepository.deleteById(id);
	}

    public  List<DemandeConger> findDemandeByEtat(Etat etat) {
        return CongerRepository.findByEtat(etat);
    }
    
    public  List<Demande> findDemandeByEtatAttente() {
       
        
        List<DemandeConger> L1= CongerRepository.findByEtatAttente(); ;
    	List<Demande> L2 = new ArrayList<Demande>();
    	
    	for (DemandeConger element : L1) {
    	    L2.add(new Demande(element));
    	}
    	
    	
        return L2;
    }
    public  List<Demande> findDemandeByEtatRefuse() {
        
        List<DemandeConger> L1= CongerRepository.findByEtatRefuse() ;
    	List<Demande> L2 = new ArrayList<Demande>();
    	
    	for (DemandeConger element : L1) {
    	    L2.add(new Demande(element));
    	}
    	
    	
        return L2;
    }
    public  List<Demande> findDemandeByEtatAccepte() {
       
        List<DemandeConger> L1= CongerRepository.findByEtatAccepte();
    	List<Demande> L2 = new ArrayList<Demande>();
    	
    	for (DemandeConger element : L1) {
    	    L2.add(new Demande(element));
    	}
    	
    	
        return L2;
    }
    public void updateJutification(DemandeConger dem) {
		CongerRepository.save(dem);
		
	}
	public void accepterDemande(DemandeConger dem) {
		CongerRepository.save(dem);
		
	}
	public void refuserDemande(DemandeConger dem) {
		CongerRepository.save(dem);
		
	}
    
    
}

