package com.itgate.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="listefavorite")
public class ListFavorite implements Serializable {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_listefavorite;

    @ManyToOne
    @JoinColumn(name = "id_candidat")
    private Candidat candidat;

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }



    @ManyToOne
    @JoinColumn(name = "id_offre")
    private OffreEmploi offres;


    
    

    public OffreEmploi getOffres() {
		return offres;
	}

	public void setOffres(OffreEmploi offres) {
		this.offres = offres;
	}

	public Long getId_listefavorite() {
        return id_listefavorite;
    }

    public void setId_listefavorite(Long id_listefavorite) {
        this.id_listefavorite = id_listefavorite;

    }


}