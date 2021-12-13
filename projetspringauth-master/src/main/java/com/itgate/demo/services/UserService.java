package com.itgate.demo.services;

import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.User;
import com.itgate.demo.models.exam.Exam;

import java.util.List;
import java.util.Set;


public interface UserService {
  //  public User findById(String id);
    public User findByUsername(String username);
    public List<User> findAll();
    public User save(User u);
  //  public String deleteById(String id);
   // public Page<Utilisateur>chercher(String mc, Pageable pageable);
	/* get user by exam Id */
	//public Set<Candidat> getUserOfExam(Exam exam);
}