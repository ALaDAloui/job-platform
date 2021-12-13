package com.itgate.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.exam.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

	
	public List<Exam> findByActive(Boolean b);
	
	
	
	 @Query("select a from Exam a where a.of = :c ")
	 List<Exam> findByoffre(@Param("c") OffreEmploi c);
	 
	 
	// SELECT * FROM Exam e WHERE offre_id=2 ORDER BY rand() LIMIT 1;

	
	 @Query(nativeQuery=true, value="SELECT * FROM Exam e WHERE e.offre_id= :c ORDER BY rand() LIMIT 1")
	 List<Exam> findrandom(@Param("c") OffreEmploi c);

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
