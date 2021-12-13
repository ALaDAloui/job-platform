package com.itgate.demo.Controlleur;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Ceil;
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

import com.itgate.demo.dao.ICandidat;
import com.itgate.demo.dao.ICandidature;
import com.itgate.demo.dao.IEntreprise;
import com.itgate.demo.dao.IEntretien;
import com.itgate.demo.dao.IRecruteur;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Candidature;
import com.itgate.demo.models.Entreprise;
import com.itgate.demo.models.Entretien;
import com.itgate.demo.models.Experience;
import com.itgate.demo.models.Recruteur;
@CrossOrigin("*")
@RestController
@RequestMapping("/users/entretien")
public class RestControllerEntretien {
	
	@Autowired
	private IEntretien iEntretien ;
	@Autowired
	private IRecruteur iRecruteur ;
	@Autowired
	private IEntreprise ientreprise;
	@Autowired
	private ICandidat iCandidat;
	@Autowired
	private ICandidature iCandidature;
	
	@PostMapping("/add/{id_entreprise}/{id_candidature}")
	public Entretien addEntretien (@RequestBody  Entretien e , @PathVariable Long id_entreprise ,
			@PathVariable Long id_candidature) {
		Entreprise r = ientreprise.findOne(id_entreprise);
		e.setEntr(r);
		
		Candidature c = iCandidature.findOne(id_candidature);
		e.setDidature(c);
		
	
		return iEntretien.save(e);
	}
	
	/*
	 * @PostMapping("/addone/{id_candidature}") public Entretien addEntret
	 * (@RequestBody Entretien e, @PathVariable Long id_candidature) {
	 * 
	 * Candidature c = iCandidature.findOne(id_candidature); e.setDidature(c);
	 * 
	 * return iEntretien.save(e); }
	 */

	
	
	@GetMapping("/getc/{id_candidature}")
	public  ResponseEntity<List<Entretien>> getbycandidature (@PathVariable Long id_candidature){

		Candidature a = iCandidature.findOne(id_candidature);
		
		return ResponseEntity.ok(iEntretien.findByCandidatture(a));
	}
	
	
	@GetMapping("/getcc/{id_candidat}")
	public  ResponseEntity<List<Entretien>> getbycandidat (@PathVariable Long id_candidat){

		Candidat a = iCandidat.findOne(id_candidat);
		
		return ResponseEntity.ok(iEntretien.findByCandidat(a));
	}

    // etat de la candidature
    
    @PutMapping("/etat1/{Id}")
    public Entretien traiter(@PathVariable Long Id){
    	Entretien p= iEntretien.findOne( Id );
        p.setAccepte( "Valider" );
     
        return iEntretien.saveAndFlush(p);
    }
    
    @PutMapping("/etat2/{Id}")
    public Entretien traiter1(@PathVariable Long Id){
    	Entretien p= iEntretien.findOne( Id );
        p.setAccepte( "Refuser" );
     
        return iEntretien.saveAndFlush(p);
    }
    
    


	@GetMapping("/all")
	public List<Entretien> getAllEntretien () {
		return iEntretien.findAll();
		
	}
	
	@GetMapping ("/GetOne/{id}")
	public Entretien getOneDemande(@PathVariable Long id){

	    return iEntretien.findOne(id);
	}
	
	@PostMapping("/save")
	public Entretien saveEntretien(@RequestBody Entretien e ) {
		return iEntretien.save(e);	
	}
	
	
	@PutMapping("/update/{Id}")
	public Entretien update (@RequestBody Entretien e , @PathVariable Long Id) {
		
		e.setId(Id);
		return iEntretien.saveAndFlush(e);
		
	}	
	
	@DeleteMapping("/delete/{Id}")
	public HashMap<String,String> deleteProduct(@PathVariable(value = "Id") Long Id) {
        HashMap message= new HashMap();
        try{
            iEntretien.delete(Id);
            message.put("etat","Entretien deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","Entretien not deleted");
            return message;
        }
    }

	

}
