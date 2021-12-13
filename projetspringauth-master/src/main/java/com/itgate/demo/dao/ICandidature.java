package com.itgate.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Candidature;
import com.itgate.demo.models.Experience;
import com.itgate.demo.models.OffreEmploi;

@Repository
public interface ICandidature extends JpaRepository<Candidature, Long> {

	

    @Query("select e from Candidature e where e.ofe = :c ")
    List<Candidature> findByOffre(@Param("c") OffreEmploi c);
    

    @Query("select e from Candidature e where e.ca = :r ")
    List<Candidature> findByCandidat(@Param("r") Candidat r);


}
