package com.itgate.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Experience;

@Repository
public interface IExperience extends JpaRepository<Experience, Long>{
	
	

    @Query("select e from Experience e where e.can = :c ")
    List<Experience> findByCandidat(@Param("c") Candidat c);

}


