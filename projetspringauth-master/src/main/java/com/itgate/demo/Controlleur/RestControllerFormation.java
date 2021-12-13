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

import com.itgate.demo.dao.ICandidat;
import com.itgate.demo.dao.IFormation;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Experience;
import com.itgate.demo.models.Formation;
@CrossOrigin("*")
@RestController
@RequestMapping("/users/formation")
public class RestControllerFormation {
	
	@Autowired
	private IFormation iFormation ;
	@Autowired
	private ICandidat iCandidat ;
	
	@PostMapping ("/add/{id_candidat}")
	public Formation addFormation (@RequestBody Formation f , @PathVariable Long id_candidat ) {
		Candidat c = iCandidat.findOne(id_candidat);
		f.setCand(c);
		
		
		return iFormation.save(f);
	}

	
	
	@GetMapping("/all/{id_candidat}")
	public  ResponseEntity< List<Formation>> getAllFormation (@PathVariable Long id_candidat) {
		
		Candidat c = iCandidat.findOne(id_candidat);
		
		 return  ResponseEntity.ok(iFormation.findByCandidat(c));
		
	}
	
	@GetMapping("/all")
	public List<Formation> getAllCandidats () {
		return iFormation.findAll();
		
	}
	
	@GetMapping ("/GetOne/{id}")
	public Formation getOneDemande(@PathVariable Long id){

	    return iFormation.findOne(id);
	}
	
	@PostMapping("/save")
	public Formation saveCandidat(@RequestBody Formation f) {
		return iFormation.save(f);	
	}
	
	
	@PutMapping("/update/{Id}")
	public Formation update (@RequestBody Formation f, @PathVariable Long Id) {
		
		f.setId(Id);
		return iFormation.saveAndFlush(f);
		
	}	
	
	@DeleteMapping("/delete/{Id}")
	public HashMap<String,String> deleteProduct(@PathVariable(value = "Id") Long Id) {
        HashMap message= new HashMap();
        try{
            iFormation.delete(Id);
            message.put("etat","entreprise deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","entreprise not deleted");
            return message;
        }
    }

}
