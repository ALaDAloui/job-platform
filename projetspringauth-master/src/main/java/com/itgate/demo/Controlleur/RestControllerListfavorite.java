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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itgate.demo.dao.ICandidat;
import com.itgate.demo.dao.IListeFavorite;
import com.itgate.demo.dao.IOffreEmploi;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Candidature;
import com.itgate.demo.models.Experience;
import com.itgate.demo.models.ListFavorite;
import com.itgate.demo.models.OffreEmploi;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/listefavorite")
public class RestControllerListfavorite {

	 @Autowired
	    private IListeFavorite iliste;
	    @Autowired
	    private ICandidat icandidat;

	    @Autowired
	    private IOffreEmploi ioffre;
	    
	    
	    
	    @GetMapping("/All")
	    public List<ListFavorite> getAlllistefavorite(){
	        return iliste.findAll();
	    }
	    
	    
	    
		
	    @GetMapping("/all/{id_candidat}")
		public  ResponseEntity< List<ListFavorite>> getAllExperienc (@PathVariable Long id_candidat) {
			
			Candidat c = icandidat.findOne(id_candidat);
			
			 return  ResponseEntity.ok(iliste.findByCandidat(c));
			
		}
		
		
		
	    @PostMapping("/save/{id_candidat}/{id_offre}")
	    public ListFavorite addliste(@RequestBody ListFavorite l  ,@PathVariable Long id_candidat,@PathVariable Long id_offre){
	    	ListFavorite liste =iliste.findById_candidats(id_candidat,id_offre);
	        if(liste== null) {
	            Candidat candidat = icandidat.findOne(id_candidat);
	            l.setCandidat(candidat);
	            OffreEmploi offre = ioffre.findOne(id_offre);
	            l.setOffres(offre);

	            return iliste.save(l);
	        }
	        return null;
	    }
	    @DeleteMapping("delete/{id}")
	    public HashMap<String, String> deleteAdministrateur(@PathVariable Long id){
	        HashMap h= new HashMap();
	        try {
	            iliste.delete(id);
	            h.put("etat","l offres sauvgarder  supprimer");
	            return h;
	        }
	        catch (Exception e)
	        {h.put("etat", "l offres sauvgarder n est pas supprimer");
	            return h;
	        }}
	}


