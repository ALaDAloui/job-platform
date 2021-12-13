package com.itgate.demo;


import com.itgate.demo.dao.IAuthority;
import com.itgate.demo.dao.IUser;
import com.itgate.demo.models.Authority;
import com.itgate.demo.models.User;
import com.itgate.demo.services.FilesStorageService;
import com.itgate.demo.utils.StorageService;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing

public class DemoApplication implements CommandLineRunner {
	
	  @Resource
	  FilesStorageService storageS;
	
    @Autowired
    private StorageService storage;


	
    @Autowired
    private IUser iUser;

    @Autowired
    private IAuthority iAuthority;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    	//storageS.deleteAll1();
    	// storageS.init();
    	
		
		//storage.init();
		  
		/*
		 * Authority authority=new Authority(); authority.setName("Admin");
		 * iAuthority.save(authority);
		 * 
		 * User user = new User(); user.setFirstName("admin");
		 * user.setLastName("admin"); user.setUsername("admin");
		 * user.setPassword(hash("admin")); user.setEnabled(true);
		 * user.setAuthorities(authority); iUser.save(user);
		 */
		 
		  
		 


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












