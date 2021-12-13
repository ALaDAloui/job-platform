package com.itgate.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Commentaire;
import com.itgate.demo.models.OffreEmploi;

@Repository
public interface ICommentaire extends JpaRepository<Commentaire, Long> {


    @Query("select e from Commentaire e where e.o = :o ")
    List<Commentaire> findByOffre(@Param("o") OffreEmploi o);
	
	
}
