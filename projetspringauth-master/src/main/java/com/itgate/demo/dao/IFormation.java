package com.itgate.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Formation;

@Repository
public interface IFormation extends JpaRepository<Formation, Long>{

	

    @Query("select f from Formation f where f.cand = :c ")
    List<Formation> findByCandidat(@Param("c") Candidat c);
}
