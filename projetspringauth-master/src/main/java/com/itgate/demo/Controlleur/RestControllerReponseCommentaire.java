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

import com.itgate.demo.dao.ICommentaire;
import com.itgate.demo.dao.IReponse;
import com.itgate.demo.dao.IUser;
import com.itgate.demo.models.Commentaire;
import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.Reponse;
import com.itgate.demo.models.User;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/reponse")
public class RestControllerReponseCommentaire {
	
	@Autowired
	private IReponse iReponse ;
	
	@Autowired
	private ICommentaire iCommentaire;
	
	@Autowired
	private IUser iUser ; 
	
	@GetMapping("/all/{id_commentaire}")
	public  ResponseEntity< List<Reponse>> getAllRep (@PathVariable Long id_commentaire) {
		
		Commentaire o = iCommentaire.findOne(id_commentaire);
		
		 return  ResponseEntity.ok(iReponse.findByRep(o));
		
	}
	
	
	@PostMapping("/add/{COMMENT_ID}/{USER_ID}")
	public Reponse addComment(@RequestBody Reponse co , @PathVariable Long COMMENT_ID , @PathVariable Long USER_ID ) {
		User u = iUser.findOne(USER_ID);
		 co.setUuu(u);
		 
		Commentaire o = iCommentaire.findOne(COMMENT_ID);
		co.setCom(o);
		
		return iReponse.save(co);
		
	
		
				}

	
		
				

	@GetMapping("/all")
	public List<Reponse> getAllRep () {
		return iReponse.findAll();
		
	}
	
	@GetMapping ("/GetOne/{id}")
	public Reponse getOneRep(@PathVariable Long id){

	    return iReponse.findOne(id);
	}
	
	@PostMapping("/save")
	public Reponse savRep(@RequestBody Reponse c ) {
		return iReponse.save(c);	
	}
	
	
	@PutMapping("/update/{Id}")
	public Reponse update (@RequestBody Reponse c , @PathVariable Long Id) {
		
		c.setId(Id);
		return iReponse.saveAndFlush(c);
		
	}	
	
	@DeleteMapping("/delete/{Id}")
	public HashMap<String,String> deleteRep(@PathVariable(value = "Id") Long Id) {
        HashMap message= new HashMap();
        try{
        	iReponse.delete(Id);
            message.put("etat","Commentaire deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","Commentaire not deleted");
            return message;
        }
    }


	
	
	
	
	

}
