package com.itgate.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Commentaire;
import com.itgate.demo.models.Reponse;

@Repository
public interface IReponse extends JpaRepository<Reponse, Long>{
	
	@Query("select e from Reponse e where e.com = :o ")
    List<Reponse> findByRep(@Param("o") Commentaire o);

}
