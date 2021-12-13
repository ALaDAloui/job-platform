package com.itgate.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Experience;
import com.itgate.demo.models.ListFavorite;
@Repository
public interface IListeFavorite  extends JpaRepository<ListFavorite, Long>{

	
	  @Query("select l from ListFavorite l where l.candidat.id=:id_candidats and l.offres.id= :id_offre")
	    ListFavorite findById_candidats (@Param("id_candidats")Long id_candidats, @Param("id_offre")Long id_offre);
	  
	  
	  @Query("select e from ListFavorite e where e.candidat = :c ")
	    List<ListFavorite> findByCandidat(@Param("c") Candidat c);
}
