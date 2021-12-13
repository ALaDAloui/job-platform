package com.itgate.demo.Controlleur;

import java.util.Date;
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
import com.itgate.demo.dao.ICandidat;
import com.itgate.demo.models.Authority;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Entreprise;
import com.itgate.demo.models.UserTokenState;
import com.itgate.demo.utils.StorageService;
@CrossOrigin("*")

@RestController
@RequestMapping("/users/candidat")
public class RestControllerCandidat {

	@Autowired
	private ICandidat iCandidat ; 
	
	@Autowired
	private IAuthority iAuthority;
	
    @Autowired
    private StorageService storage;
	
	
	@RequestMapping("/registercandidat")
	public ResponseEntity<?> register(Candidat c, @RequestParam("file") MultipartFile file )
	{
	    Authority authority=new Authority();
	    authority.setName("candidat");
	    iAuthority.save(authority);

	    c.setEnabled(true);
	    c.setAuthorities(authority);
	    c.setPassword(hash(c.getPassword()));
	    int i = (int) new Date().getTime();
	    System.out.println("Integer : " + i);
	    storage.store(file);
	    c.setImage(i+file.getOriginalFilename());

	    iCandidat.save(c);

	    return ResponseEntity.ok(new UserTokenState(null, 0, c));

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
	
	
	@GetMapping("/all")
	public List<Candidat> getAllCandidats () {
		return iCandidat.findAll();
		
	}
	
	@GetMapping("/GetOne/{Id}")
	public Candidat getCandidat (@PathVariable Long Id) {
		return iCandidat.findOne(Id);
	}
	
	@PostMapping("/save")
	public Candidat saveCandidat(@RequestBody Candidat c ) {
		return iCandidat.save(c);	
	}
	
	
	@PutMapping("/update/{Id}")
	public Candidat update (@RequestBody Candidat c , @PathVariable Long Id) {
		
		c.setId(Id);
		return iCandidat.saveAndFlush(c);
		
	}	
	
	@DeleteMapping("/delete/{Id}")
	public HashMap<String,String> deleteProduct(@PathVariable(value = "Id") Long Id) {
        HashMap message= new HashMap();
        try{
            iCandidat.delete(Id);
            message.put("etat","candidat deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","candidat not deleted");
            return message;
        }
    }
	
    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

