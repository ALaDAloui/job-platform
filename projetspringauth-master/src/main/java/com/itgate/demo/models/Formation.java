package com.itgate.demo.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ecole;
	private String diplome;
	private String domaineEtude;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateDebut;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateFin ;
	private String description;
	private String resultat;
	
	@ManyToOne
	@JoinColumn(name = "Candida_ID")
	private Candidat cand ;
	
	
	
	public Candidat getCand() {
		return cand;
	}
	public void setCand(Candidat cand) {
		this.cand = cand;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEcole() {
		return ecole;
	}
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getDomaineEtude() {
		return domaineEtude;
	}
	public void setDomaineEtude(String domaineEtude) {
		this.domaineEtude = domaineEtude;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
	
	
	

}
