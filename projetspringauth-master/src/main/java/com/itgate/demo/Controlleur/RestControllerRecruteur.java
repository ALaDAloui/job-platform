package com.itgate.demo.Controlleur;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itgate.demo.dao.IEntreprise;
import com.itgate.demo.dao.IRecruteur;
import com.itgate.demo.models.Entreprise;
import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.Recruteur;
@CrossOrigin("*")
@RestController
@RequestMapping("/recruteur")
public class RestControllerRecruteur {

	
	@Autowired
	private IRecruteur iRecruteur;
	@Autowired
	private IEntreprise iEntreprise;
	
	@PostMapping("/add/{id_entreprise}")
	public Recruteur addRecrut (@RequestBody Recruteur r , @PathVariable Long id_entreprise) {
		Entreprise e = iEntreprise.findOne(id_entreprise);
		r.setEnt(e);
		
		return iRecruteur.save(r);
		
	}
	
	@GetMapping("/all")
	public List<Recruteur> getAllRecr () {
		return iRecruteur.findAll();
	}
		
	@GetMapping ("/GetOne/{id}")
	public Recruteur getOneDemande(@PathVariable Long id){

	    return iRecruteur.findOne(id);
	}
	
	
	@PostMapping("/save")
	public Recruteur saveCandidat(@RequestBody Recruteur r ) {
		return iRecruteur.save(r);	
	}
	
	
	@PutMapping("/update/{Id}")
	public Recruteur update (@RequestBody Recruteur r , @PathVariable Long Id) {
		
		r.setId(Id);
		return iRecruteur.saveAndFlush(r);
		
	}	
	
	@DeleteMapping("/delete/{Id}")
	public HashMap<String,String> deleteProduct(@PathVariable(value = "Id") Long Id) {
        HashMap message= new HashMap();
        try{
            iRecruteur.delete(Id);
            message.put("etat","entreprise deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","entreprise not deleted");
            return message;
        }
    }
	
	
}
