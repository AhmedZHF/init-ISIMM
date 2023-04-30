package com.example.demo.gestionConge.exempleEntity;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.DemandeConger;
import com.example.demo.entities.enums.Etat;



@CrossOrigin
@RestController
@RequestMapping("api/isimm/gestionConge/demandeconger")
public class CongeEntityController {
	@Autowired
    private  CongeEntityServices entityService;

    
    
    @PostMapping(path="/add")
    public String add(@RequestBody DemandeConger demande){
    	entityService.saveDemande(demande);
        return "New Demande is added";
    }
    
   
    
    @GetMapping(path="{demandeId}")
    public Optional<DemandeConger> getDemande(@PathVariable("demandeId") Long demandeId){
    	
       return entityService.getDemande(demandeId);
    }
    
   
    @GetMapping(path="/getAll")
    public List<Demande> list(){
    
    	
        return entityService.getAllDemande();
        
    }
    
    
    
    
    /*@GetMapping("/etat/{etat}")
    public List<DemandeConger> getDemandByEtat(@PathVariable Etat etat) {
     return entityService.findDemandeByEtat(etat);
       
    }*/
    
    
    @GetMapping("/attente")
    public List<DemandeConger> getDemandByEtatAttente() {
     return entityService.findDemandeByEtatAttente();
       
    }
    
    
    @GetMapping("/refuse")
    public List<DemandeConger> getDemandByEtatRefuse() {
     return entityService.findDemandeByEtatRefuse();
       
    }
   
    
    @GetMapping("/accepte")
    public List<DemandeConger> getDemandByEtatAccepte() {
     return entityService.findDemandeByEtatAccepte();
       
    }
    
  /*  @PutMapping(path ="/{id}/Justification")
    public ResponseEntity<Void> updateDemandeById(@PathVariable Long id ,@RequestParam String Justification) {
        Optional<DemandeConger> demande1 = entityService.getDemande(id);
        if (demande1 != null) {
        	DemandeConger dem=demande1.get();
        	dem.setJustification(Justification);
        	entityService.updateJutification(dem);
        	
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    } */
   
    @PutMapping(path ="/accepter/{id}/etat")
    public ResponseEntity<Void> accepterDemandeById(@PathVariable Long id ,@RequestParam Etat etat) {
        Optional<DemandeConger> demande1 = entityService.getDemande(id);
        if (demande1 != null) {
        	DemandeConger dem=demande1.get();
        	dem.setEtatDemande(etat);
        	entityService.accepterDemande(dem);
        	
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
    @PutMapping(path ="/refuser/{id}/etat")
    public ResponseEntity<Void> refuserDemandeById(@PathVariable Long id ,@RequestParam Etat etat) {
        Optional<DemandeConger> demande1 = entityService.getDemande(id);
        if (demande1 != null) {
        	DemandeConger dem=demande1.get();
        	dem.setEtatDemande(etat);
        	entityService.refuserDemande(dem);
        	
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDemandeById(@PathVariable Long id) {
        Optional<DemandeConger> demande = entityService.getDemande(id);
        if (demande != null) {
        	entityService.deleteDemanderById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
        
        
    }
}
