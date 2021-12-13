package com.itgate.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Candidature;
import com.itgate.demo.models.Entreprise;
import com.itgate.demo.models.Entretien;

@Repository
public interface IEntretien extends JpaRepository<Entretien, Long>{
	


    @Query("select e from Entretien e where e.c = :a ")
    List<Entretien> findByCandidat(@Param("a") Candidat a);	

    @Query("select e from Entretien e where e.didature = :a ")
    List<Entretien> findByCandidatture(@Param("a") Candidature a);	
}
