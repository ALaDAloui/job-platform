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

import com.itgate.demo.dao.ICategorieOffre;
import com.itgate.demo.models.CategorieOffre;
import com.itgate.demo.models.Entreprise;
@CrossOrigin("*")

@RestController
@RequestMapping("/users/categorie")
public class RestControllerCategorieOffre {
	
	@Autowired
	private ICategorieOffre iCategorieOffre;
	
	@GetMapping("/all")
	public List<CategorieOffre> getAllCandidats () {
		return iCategorieOffre.findAll();
		
	}
	
	@GetMapping ("/GetOne/{id}")
	public CategorieOffre getOneDemande(@PathVariable Long id){

	    return iCategorieOffre.findOne(id);
	}
	
	@PostMapping("/save")
	public CategorieOffre saveCandidat(@RequestBody CategorieOffre c ) {
		return iCategorieOffre.save(c);	
	}
	
	
	@PutMapping("/update/{Id}")
	public CategorieOffre update (@RequestBody CategorieOffre c , @PathVariable Long Id) {
		
		c.setId(Id);
		return iCategorieOffre.saveAndFlush(c);
		
	}	
	
	@DeleteMapping("/delete/{Id}")
	public HashMap<String,String> deleteProduct(@PathVariable(value = "Id") Long Id) {
        HashMap message= new HashMap();
        try{
            iCategorieOffre.delete(Id);
            message.put("etat","categorie deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","categorie not deleted");
            return message;
        }
    }



}
