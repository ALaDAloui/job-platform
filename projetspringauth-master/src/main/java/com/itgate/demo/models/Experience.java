package com.itgate.demo.models;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itgate.demo.models.exam.Exam;

@Entity
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomPoste ;
	private String typeEmploi;
	private String nomEntreprise;
	private String lieu;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateDebut;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateFin ;
	private String titre;
	private String secteur ;
	
	@ManyToOne
	@JoinColumn(name = "Candidat_ID")
	private Candidat can ;
	
	@OneToMany(mappedBy = "en")
	private Collection<Exam> exams;
	
	public Candidat getCan() {
		return can;
	}
	public void setCan(Candidat can) {
		this.can = can;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomPoste() {
		return nomPoste;
	}
	public void setNomPoste(String nomPoste) {
		this.nomPoste = nomPoste;
	}
	public String getTypeEmploi() {
		return typeEmploi;
	}
	public void setTypeEmploi(String typeEmploi) {
		this.typeEmploi = typeEmploi;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
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
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getSecteur() {
		return secteur;
	}
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
	
	
	
	
	

}
