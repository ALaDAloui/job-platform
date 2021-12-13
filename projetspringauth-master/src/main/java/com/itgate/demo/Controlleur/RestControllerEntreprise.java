package com.itgate.demo.Controlleur;

import java.util.Date;
import com.itgate.demo.utils.StorageService;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import org.springframework.web.multipart.MultipartFile;

import com.itgate.demo.dao.IAuthority;
import com.itgate.demo.dao.IEntreprise;
import com.itgate.demo.models.Authority;
import com.itgate.demo.models.Candidature;
import com.itgate.demo.models.Entreprise;
import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.UserTokenState;
@CrossOrigin("*")
@RestController
@RequestMapping("/users/entreprise")
public class RestControllerEntreprise {
	
	@Autowired
	private IEntreprise iEntreprise ;

    @Autowired
    private IAuthority iAuthority;
    @Autowired
    private StorageService storage;
	@GetMapping("/all")
	public List<Entreprise> getAllCandidats () {
		return iEntreprise.findAll();
		
	}
	
  // etat de l'entreprise
    
    @PutMapping("/etat1/{Id}")
    public Entreprise traiter(@PathVariable Long Id){
        Entreprise p= iEntreprise.findOne( Id );
        p.setEtat( "Valider" );
     
        return iEntreprise.saveAndFlush(p);
    }
    
    @PutMapping("/etat2/{Id}")
    public Entreprise traiter1(@PathVariable Long Id){
    	Entreprise p= iEntreprise.findOne( Id );
        p.setEtat( "Refuser" );
     
        return iEntreprise.saveAndFlush(p);
    }
	
	@RequestMapping("/registerentreprise")
	public ResponseEntity<?> register(Entreprise e, @RequestParam("file") MultipartFile file )
	{
	    Authority authority=new Authority();
	    authority.setName("entreprise");
	    iAuthority.save(authority);

	    e.setEnabled(true);
	    e.setAuthorities(authority);
	    e.setPassword(hash(e.getPassword()));
	    int i = (int) new Date().getTime();
	    System.out.println("Integer : " + i);
	    storage.store(file);
	    e.setImage(i+file.getOriginalFilename());

	    iEntreprise.save(e);

	    return ResponseEntity.ok(new UserTokenState(null, 0, e));

	}
	  String hash(String password) {


	        String hashedPassword = null;
	        int i = 0;
	        while (i < 5) {
	            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	            hashedPassword = passwordEncoder.encode(password);
	            i++;
	        }

	        return hashedPassword;
	    }

	  @PutMapping("/modifimage/{id}")
	  public Entreprise modif(@RequestParam("file") MultipartFile file, @PathVariable Long id){
		  Entreprise c = iEntreprise.findOne(id);
	     // c.setId(id);
	     // int i = (int) new Date().getTime();
	     // System.out.println("Integer : " + i);
	      storage.store2(file);
	      c.setImage(file.getOriginalFilename());
	      return iEntreprise.saveAndFlush(c) ;
	  }
	
	@GetMapping ("/GetOne/{id}")
	public Entreprise getOneDemande(@PathVariable Long id){

	    return iEntreprise.findOne(id);
	}
	
	@PostMapping("/save")
	public Entreprise saveCandidat(@RequestBody Entreprise e ) {
		return iEntreprise.save(e);	
	}
	
	@PutMapping("/updatedescr/{Id}")
	public Entreprise updateDescription ( @PathVariable Long Id , @RequestBody String Description) {
		
		Entreprise e = iEntreprise.findOne(Id);
		e.setDescription(Description);
		return iEntreprise.saveAndFlush(e);
		
	}	
	
	
	@PutMapping("/update/{Id}")
	public Entreprise update (@RequestBody Entreprise e , @PathVariable Long Id) {
		
		e.setId(Id);
		return iEntreprise.saveAndFlush(e);
		
	}	
	
	@DeleteMapping("/delete/{Id}")
	public HashMap<String,String> deleteProduct(@PathVariable(value = "Id") Long Id) {
        HashMap message= new HashMap();
        try{
            iEntreprise.delete(Id);
            message.put("etat","entreprise deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","entreprise not deleted");
            return message;
        }
    }

}
