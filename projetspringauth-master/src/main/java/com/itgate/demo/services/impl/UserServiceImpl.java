package com.itgate.demo.services.impl;

import com.itgate.demo.dao.ICandidat;
import com.itgate.demo.dao.IUser;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.User;
import com.itgate.demo.models.exam.Exam;
import com.itgate.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUser userRepository;
    
    @Autowired
    private ICandidat iCandidat;

    @Override
   public User findByUsername( String username ) throws UsernameNotFoundException {
        User u = userRepository.findByUsername( username );
        return u;
    }


    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }
    
    public User save(User u)
    {
    	return userRepository.save(u);
    }
    
	/*
	 * @Override
	 * 
	 * public Set<Candidat> getUserOfExam(Exam exams) { return
	 * this.iCandidat.findByExam(exams); }
	 */


	/*@Override
	public Page<Utilisateur> chercher(String mc, Pageable pageable) {
		return userRepository.chercher(mc, pageable);
	}*/
}