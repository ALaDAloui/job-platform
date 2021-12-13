package com.itgate.demo.Controlleur;
import com.itgate.demo.dao.INotification;
import com.itgate.demo.dao.IOffreEmploi;
import com.itgate.demo.dao.IUser;
import com.itgate.demo.models.Notification;
import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/notifications")
public class NotificationController {
    @Autowired
    private INotification inotification;

    @Autowired
    private IOffreEmploi iOffreEmploi;


    @Autowired
    private IUser iUser;

    ArrayList liste = new ArrayList();


    @PostMapping("/save/{id_offre}")
    public Notification notification(@PathVariable Long id_offre,
                                     @RequestBody Notification notification ) {
    	
    	OffreEmploi o = iOffreEmploi.findOne(id_offre);
    	notification.setEe(o);
    	
    	return inotification.save(notification);
    	
 
    }
    
    

    @GetMapping("/all")
    public List<Notification> getAllnotification() {
        return inotification.findAll();
    }
    
    
    
    
    
    
}
