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

import com.itgate.demo.dao.IMessage;
import com.itgate.demo.dao.IUser;
import com.itgate.demo.models.Message;
import com.itgate.demo.models.User;
@CrossOrigin("*")
@RestController
@RequestMapping("/message")
public class RestControllerMessage {
	
	@Autowired
	private IMessage iMessage;
	@Autowired
	private IUser iUser;
	
	

	@GetMapping("/all")
	public List<Message> getAllCandidats () {
		return iMessage.findAll();
		
	}
	
	@GetMapping ("/GetOne/{id}")
	public Message getOneDemande(@PathVariable Long id){

	    return iMessage.findOne(id);
	}
	
	@PostMapping("/save")
	public Message saveCandidat(@RequestBody Message m ) {
		return iMessage.save(m);	
	}
	
	
	
	
	@DeleteMapping("/delete/{Id}")
	public HashMap<String,String> deleteProduct(@PathVariable(value = "Id") Long Id) {
        HashMap message= new HashMap();
        try{
            iMessage.delete(Id);
            message.put("etat","Message deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","Message not deleted");
            return message;
        }
    }
}
