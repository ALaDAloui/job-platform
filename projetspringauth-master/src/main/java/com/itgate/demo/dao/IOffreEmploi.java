package com.itgate.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.CategorieOffre;
import com.itgate.demo.models.Entreprise;
import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.exam.Exam;

@Repository
public interface IOffreEmploi extends JpaRepository<OffreEmploi, Long>{

	
	 @Query("select a from OffreEmploi a where a.e = :c ")
	    List<OffreEmploi> findByEntreprise(@Param("c") Entreprise c);
	 
	 
	 
	 @Query("select r from OffreEmploi r where r.co = :y ")
	    List<OffreEmploi> findByCategorie(@Param("y") CategorieOffre y);
	 
	 @Query(nativeQuery=true, value="SELECT * FROM offre_emploi ORDER BY rand() LIMIT 4")
	 List<OffreEmploi> findrandom();
}
