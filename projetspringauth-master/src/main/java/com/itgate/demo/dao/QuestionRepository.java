package com.itgate.demo.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Candidature;
import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.exam.Exam;
import com.itgate.demo.models.exam.Question;

@Repository
public interface QuestionRepository  extends JpaRepository<Question, Long>{

	Set<Question> findByExam(Exam exam);

	   @Query("select e from Question e where e.exam = :c ")
	    List<Question> findByexam(@Param("c") Exam c);
	    
}
