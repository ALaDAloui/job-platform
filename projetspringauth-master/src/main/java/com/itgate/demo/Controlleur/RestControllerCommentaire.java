package com.itgate.demo.Controlleur;

import java.util.HashMap;
import java.util.List;
import javax.websocket.server.PathParam;

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

import com.itgate.demo.dao.ICommentaire;
import com.itgate.demo.dao.IOffreEmploi;
import com.itgate.demo.dao.IUser;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Candidature;
import com.itgate.demo.models.Commentaire;
import com.itgate.demo.models.Experience;
import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.User;

@RestController
@RequestMapping("/users/commentaire")
@CrossOrigin("*")

public class RestControllerCommentaire {
	
	@Autowired
	private ICommentaire iCommentaire;
	
	@Autowired
	private IOffreEmploi iOffreEmploi;
	
	@Autowired
	private IUser iUser;
	
	
	
	@GetMapping("/all/{id_offre}")
	public  ResponseEntity< List<Commentaire>> getAllExperienc (@PathVariable Long id_offre) {
		
		OffreEmploi o = iOffreEmploi.findOne(id_offre);
		
		 return  ResponseEntity.ok(iCommentaire.findByOffre(o));
		
	}
	
	@PostMapping("/add/{OFFRE_ID}/{USER_ID}")
	public Commentaire addComment(@RequestBody Commentaire co , @PathVariable Long USER_ID , @PathVariable Long OFFRE_ID ) {
		User u = iUser.findOne(USER_ID);
		 co.setUse(u);
		 
		OffreEmploi o = iOffreEmploi.findOne(OFFRE_ID);
		co.setO(o);
		
		return iCommentaire.save(co);
		
	
		
				}

	
	
	@GetMapping("/all")
	public List<Commentaire> getAllComments () {
		return iCommentaire.findAll();
		
	}
	
	@GetMapping ("/GetOne/{id}")
	public Commentaire getOneDemande(@PathVariable Long id){

	    return iCommentaire.findOne(id);
	}
	
	@PostMapping("/save")
	public Commentaire saveCandidat(@RequestBody Commentaire c ) {
		return iCommentaire.save(c);	
	}
	
	
	@PutMapping("/update/{Id}")
	public Commentaire update (@RequestBody Commentaire c , @PathVariable Long Id) {
		
		c.setId(Id);
		return iCommentaire.saveAndFlush(c);
		
	}	
	
	@DeleteMapping("/delete/{Id}")
	public HashMap<String,String> deleteProduct(@PathVariable(value = "Id") Long Id) {
        HashMap message= new HashMap();
        try{
            iCommentaire.delete(Id);
            message.put("etat","Commentaire deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","Commentaire not deleted");
            return message;
        }
    }


}
