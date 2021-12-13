package com.itgate.demo.Controlleur;

import java.util.HashMap;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.itgate.demo.dao.ICategorieOffre;
import com.itgate.demo.dao.IEntreprise;
import com.itgate.demo.dao.IOffreEmploi;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Candidature;
import com.itgate.demo.models.CategorieOffre;
import com.itgate.demo.models.Entreprise;
import com.itgate.demo.models.Experience;
import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.exam.Exam;
@CrossOrigin("*")
@RestController
@RequestMapping("/users/offre")
public class RestControllerOffreEmploi {
	
	@Autowired
	private IOffreEmploi iOffreEmploi ;
	@Autowired
	private IEntreprise ientreprise ;
	@Autowired
	private ICategorieOffre iCategorieOffre ;
	
	
	
	@PostMapping("/add/{identreprise}/{idcategorie}")
	public OffreEmploi Addoffre(@RequestBody OffreEmploi offre,@PathVariable Long identreprise, @PathVariable Long idcategorie) {
		
	  Entreprise e= ientreprise.findOne(identreprise);
	  offre.setE(e);
	  
	  CategorieOffre c= iCategorieOffre.findOne(idcategorie);
	   offre.setCo(c);
	   
	  return iOffreEmploi.save(offre);
	}
	
	@GetMapping("/all/{id_entreprise}")
	
	public  ResponseEntity< List<OffreEmploi>> getAllOffre (@PathVariable Long id_entreprise) {
		
		Entreprise c = ientreprise.findOne(id_entreprise);
		
		 return  ResponseEntity.ok(iOffreEmploi.findByEntreprise(c));
		
	}
	
	@GetMapping("/allbycat/{id_categorie}")
	public ResponseEntity<List<OffreEmploi>> getAllOffreByCatgorie (@PathVariable Long id_categorie) {
		
		CategorieOffre y = iCategorieOffre.findOne(id_categorie);
	
		return ResponseEntity.ok(iOffreEmploi.findByCategorie(y));
		
	}
	
	// get offre random
	
    @GetMapping("/RandomOffre")
	
	public  List<OffreEmploi> getRandomOffre () {
		
		
		return iOffreEmploi.findrandom();

		
	}
	
	@GetMapping("/all")
	public List<OffreEmploi> getAllCandidats () {
		return iOffreEmploi.findAll();
		
	}
	
  // etat de la offre
    
    @PutMapping("/status1/{Id}")
    public OffreEmploi traiter(@PathVariable Long Id){
        OffreEmploi p= iOffreEmploi.findOne( Id );
        p.setStatus( "valider" );
     
        return iOffreEmploi.saveAndFlush(p);
    }
    
    @PutMapping("/status2/{Id}")
    public OffreEmploi traiter1(@PathVariable Long Id){
    	OffreEmploi p= iOffreEmploi.findOne( Id );
        p.setStatus( "refuser" );
     
        return iOffreEmploi.saveAndFlush(p);
    }
    
	
	@GetMapping ("/GetOne/{id}")
	public OffreEmploi getOneDemande(@PathVariable Long id){

	    return iOffreEmploi.findOne(id);
	}
	
	@PostMapping("/save")
	public OffreEmploi saveCandidat(@RequestBody OffreEmploi o ) {
		return iOffreEmploi.save(o);	
	}
	
	
	@PutMapping("/update/{Id}")
	public OffreEmploi update (@RequestBody OffreEmploi o , @PathVariable Long Id) {
		
		o.setId(Id);
		return iOffreEmploi.saveAndFlush(o);
		
	}	
	
	@DeleteMapping("/delete/{Id}")
	public HashMap<String,String> deleteProduct(@PathVariable(value = "Id") Long Id) {
        HashMap message= new HashMap();
        try{
            iOffreEmploi.delete(Id);
            message.put("etat","OffreEmploi deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","OffreEmploi not deleted");
            return message;
        }
    }

}
