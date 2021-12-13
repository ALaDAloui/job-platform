package com.itgate.demo.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Experience;
import com.itgate.demo.models.exam.Exam;

@Repository
public interface ICandidat extends JpaRepository<Candidat, Long>{

	
	//Set<Candidat> findByExam(Exam exams);

}
