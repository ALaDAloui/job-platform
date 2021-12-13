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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itgate.demo.dao.IAdministrateur;
import com.itgate.demo.dao.IAuthority;
import com.itgate.demo.models.Administrateur;
import com.itgate.demo.models.Authority;
import com.itgate.demo.models.UserTokenState;
import com.itgate.demo.utils.StorageService;
@CrossOrigin("*")
@RestController
@RequestMapping("/users/admin")
public class RestControlleAdministrateur {

	@Autowired
    private IAuthority iAuthority;
    @Autowired
    private StorageService storage;

   @Autowired
    private IAdministrateur iadmins;


    @GetMapping("/All")
    public List<Administrateur> getAllAdministrateur(){
        return iadmins.findAll();
    }

    @RequestMapping("/registerAdmin")
    public ResponseEntity<?> register(Administrateur a, @RequestParam("file") MultipartFile file )
    {
        Authority authority=new Authority();
        authority.setName("ADMIN");
        iAuthority.save(authority);

        a.setEnabled(true);
        a.setAuthorities(authority);
        a.setPassword(hash(a.getPassword()));
        int i = (int) new Date().getTime();
        System.out.println("Integer : " + i);
        storage.store2(file, i+file.getOriginalFilename());
        a.setImage(i+file.getOriginalFilename());


        iadmins.save(a);

        return ResponseEntity.ok(new UserTokenState(null, 0,a));

    }
    @PutMapping("/modif/{id}")
    public Administrateur modif(@RequestBody Administrateur a, @PathVariable Long id){
        a.setId(id);
        return iadmins.saveAndFlush(a);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String, String> deleteAdministrateur(@PathVariable Long id){
        HashMap h= new HashMap();
        try {
            iadmins.delete(id);
            h.put("etat","Administrateur supprimer");
            return h;
        }
        catch (Exception e)
        {h.put("etat", "Administrateur non supprimer");
            return h;
        }

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


}
