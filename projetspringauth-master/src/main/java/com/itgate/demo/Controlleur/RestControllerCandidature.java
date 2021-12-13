package com.itgate.demo.Controlleur;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itgate.demo.dao.ICandidat;
import com.itgate.demo.dao.ICandidature;
import com.itgate.demo.dao.IEntreprise;
import com.itgate.demo.dao.IOffreEmploi;
import com.itgate.demo.message.ResponseMessage;
import com.itgate.demo.models.Authority;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Candidature;
import com.itgate.demo.models.Entreprise;
import com.itgate.demo.models.Experience;
import com.itgate.demo.models.FileInfo;
import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.User;
import com.itgate.demo.models.UserTokenState;
import com.itgate.demo.services.FilesStorageService;
import com.itgate.demo.utils.StorageService;
@CrossOrigin("*")

@RestController
@RequestMapping("/users/candidature")

public class RestControllerCandidature {
	
	@Autowired
	private ICandidature iCandidature;

	@Autowired
	private ICandidat iCandidat;

	@Autowired
	private IOffreEmploi iOffreEmploi;
	
	@Autowired
	private IEntreprise iEntreprise ;

	@Autowired
    FilesStorageService storageService;

	/*
	 * @PostMapping("/upload")
	 * 
	 * public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")
	 * MultipartFile file) { String message = ""; try { storageService.save(file);
	 * 
	 * message = "Uploaded the file successfully: " + file.getOriginalFilename();
	 * return ResponseEntity.status(HttpStatus.OK).body(new
	 * ResponseMessage(message)); } catch (Exception e) { message =
	 * "Could not upload the file: " + file.getOriginalFilename() + "!"; return
	 * ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new
	 * ResponseMessage(message)); } }
	 */
	  
    @RequestMapping("/addcand/{id_offre}/{id_candidat}")
    public ResponseEntity<?> register(Candidature candidature, @RequestParam("file") MultipartFile file ,
    		@PathVariable Long id_offre, @PathVariable Long id_candidat )
    {
        

		OffreEmploi o = iOffreEmploi.findOne(id_offre);
		candidature.setOfe(o);

		Candidat c = iCandidat.findOne(id_candidat);
		candidature.setCa(c);

    	
    	storageService.save(file);
    	candidature.setUrl(file.getOriginalFilename());
    	candidature.setName(file.getName());

        iCandidature.save(candidature);

        return ResponseEntity.ok(candidature);

    }
    
    // etat de la candidature
    
    @PutMapping("/etat1/{Id}")
    public Candidature traiter(@PathVariable Long Id){
        Candidature p= iCandidature.findOne( Id );
        p.setEtat( "Valider" );
     
        return iCandidature.saveAndFlush(p);
    }
    
    @PutMapping("/etat2/{Id}")
    public Candidature traiter1(@PathVariable Long Id){
        Candidature p= iCandidature.findOne( Id );
        p.setEtat( "Refuser" );
     
        return iCandidature.saveAndFlush(p);
    }
    
    
    
	@PostMapping("/add/{id_offre}/{id_candidat}")
	public Candidature addCandidature(@RequestBody Candidature candidature, @PathVariable Long id_offre,
			@PathVariable Long id_candidat) {

		OffreEmploi o = iOffreEmploi.findOne(id_offre);
		candidature.setOfe(o);

		Candidat c = iCandidat.findOne(id_candidat);
		candidature.setCa(c);

		return iCandidature.save(candidature);
	}
	
	  @PutMapping("/updatenote/{Id}")
	    public Candidature updatenote(@RequestBody String note ,@PathVariable Long Id ){
	        Candidature p= iCandidature.findOne( Id );
	        p.setNote(note);
	     
	        return iCandidature.saveAndFlush(p);
	    }
	
	@GetMapping("/all/{id_offre}")
	
	public  ResponseEntity< List<Candidature>> getAllCandidature (@PathVariable Long id_offre) {
		
		OffreEmploi c = iOffreEmploi.findOne(id_offre);
		
		 return  ResponseEntity.ok(iCandidature.findByOffre(c));
		
	}
	
	@GetMapping("/allc/{id_candidat}")
	public  ResponseEntity< List<Candidature>> getAllbyCandidat (@PathVariable Long id_candidat) {
		
		Candidat r = iCandidat.findOne(id_candidat);
		
		 return  ResponseEntity.ok(iCandidature.findByCandidat(r));
		
	}
	

	@GetMapping("/all")
	public List<Candidature> getAllC() {
		return iCandidature.findAll();

	}

	@GetMapping("/GetOne/{id}")
	public Candidature getOneDemande(@PathVariable Long id) {

		return iCandidature.findOne(id);
	}

	@PostMapping("/save")
	public Candidature saveCandidat(@RequestBody Candidature c) {
		return iCandidature.save(c);
	}

	@PutMapping("/update/{Id}")
	public Candidature update(@RequestBody Candidature c, @PathVariable Long Id) {

		c.setId(Id);
		return iCandidature.saveAndFlush(c);

	}

	@DeleteMapping("/delete/{Id}")
	public HashMap<String, String> deleteProduct(@PathVariable(value = "Id") Long Id) {
		HashMap message = new HashMap();
		try {
			iCandidature.delete(Id);
			message.put("etat", "Candidature deleted");
			return message;
		} catch (Exception e) {
			message.put("etat", "Candidature not deleted");
			return message;
		}
	}

}
