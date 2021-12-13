package com.itgate.demo.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itgate.demo.models.exam.Exam;

@Entity
public class Entreprise extends User {
	
	
	private String nom_entreprise ;
	private String anneeCreation ;
	private String adresse ; 
	private String siteWeb;
	private String sect_activite ;
	private String description;
	private String region;
	private String  telephone ;
	private String logo ;
	private String etat;
	private String fblink;
	private String instalink;
	private String linkedlink;
	private String twitterlink;

	
	
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	@OneToMany(mappedBy = "e")
	private Collection<OffreEmploi> offres;

	@OneToMany(mappedBy = "en")
	private Collection<Exam> exams ;
	
	@OneToMany(mappedBy = "entr")
	private Collection<Entretien> entretien;

	@OneToMany(mappedBy = "ent")
	private Collection<Recruteur> recruteurs ;
	
	
	
	
	@JsonIgnore
	public Collection<Entretien> getEntretien() {
		return entretien;
	}
	public void setEntretien(Collection<Entretien> entretien) {
		this.entretien = entretien;
	}
	@JsonIgnore
	public Collection<OffreEmploi> getOffres() {
		return offres;
	}
	public void setOffres(Collection<OffreEmploi> offres) {
		this.offres = offres;
	}
	@JsonIgnore
	public Collection<Recruteur> getRecruteurs() {
		return recruteurs;
	}
	public void setRecruteurs(Collection<Recruteur> recruteurs) {
		this.recruteurs = recruteurs;
	}
	
	@JsonIgnore
	public Collection<Exam> getExams() {
		return exams;
	}
	public void setExams(Collection<Exam> exams) {
		this.exams = exams;
	}
	public String getFblink() {
		return fblink;
	}
	public void setFblink(String fblink) {
		this.fblink = fblink;
	}
	public String getInstalink() {
		return instalink;
	}
	public void setInstalink(String instalink) {
		this.instalink = instalink;
	}
	public String getLinkedlink() {
		return linkedlink;
	}
	public void setLinkedlink(String linkedlink) {
		this.linkedlink = linkedlink;
	}
	public String getTwitterlink() {
		return twitterlink;
	}
	public void setTwitterlink(String twitterlink) {
		this.twitterlink = twitterlink;
	}
	public String getSect_activite() {
		return sect_activite;
	}
	public void setSect_activite(String sect_activite) {
		this.sect_activite = sect_activite;
	}
	public String getNom_entreprise() {
		return nom_entreprise;
	}
	public void setNom_entreprise(String nom_entreprise) {
		this.nom_entreprise = nom_entreprise;
	}

	
	
	  public String getAnneeCreation() { return anneeCreation; } public void
	  setAnneeCreation(String anneeCreation) { this.anneeCreation = anneeCreation; }
	 
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSiteWeb() {
		return siteWeb;
	}
	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	

}
