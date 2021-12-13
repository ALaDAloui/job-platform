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
import com.itgate.demo.dao.IExperience;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Experience;
import com.itgate.demo.models.Message;
import com.itgate.demo.models.User;
@CrossOrigin("*")
@RestController
@RequestMapping("users/experience")
public class RestControllerExperience {
	
	@Autowired
	private IExperience iExperience;
	@Autowired
	private ICandidat iCandidat;
	
	@PostMapping ("/add/{id_candidat}")
	public Experience addExperience (@RequestBody Experience e , @PathVariable Long id_candidat ) {
		Candidat c = iCandidat.findOne(id_candidat);
		e.setCan(c);
		
		return iExperience.save(e);
		
	}
	
	@GetMapping("/all/{id_candidat}")
	public  ResponseEntity< List<Experience>> getAllExperienc (@PathVariable Long id_candidat) {
		
		Candidat c = iCandidat.findOne(id_candidat);
		
		 return  ResponseEntity.ok(iExperience.findByCandidat(c));
		
	}
	
	@GetMapping("/all")
	public List<Experience> getAllExperience () {
		return iExperience.findAll();
		
	}
	
	@GetMapping ("/GetOne/{id}")
	public Experience getOneDemande(@PathVariable Long id){

	    return iExperience.findOne(id);
	}
	
	@PostMapping("/save")
	public Experience saveCandidat(@RequestBody Experience e ) {
		return iExperience.save(e);	
	}
	
	
	@PutMapping("/update/{Id}")
	public Experience update (@RequestBody Experience e , @PathVariable Long Id) {
		
		e.setId(Id);
		return iExperience.saveAndFlush(e);
		
	}	
	
	@DeleteMapping("/delete/{Id}")
	public HashMap<String,String> deleteProduct(@PathVariable(value = "Id") Long Id) {
        HashMap message= new HashMap();
        try{
            iExperience.delete(Id);
            message.put("etat","entreprise deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","entreprise not deleted");
            return message;
        }
    }


}
