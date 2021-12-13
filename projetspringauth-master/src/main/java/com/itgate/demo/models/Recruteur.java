package com.itgate.demo.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itgate.demo.models.exam.Exam;

@Entity
public class Recruteur extends User {
	
	
	private String nom ;
	private String prenom;
	private String poste ;
	private String email ;
	private int telephone ;
	
	
	@OneToMany(mappedBy = "r")
	private Collection<Entretien> entretiens;
	

	
    @ManyToOne
	@JoinColumn(name = "ENTREPRISE_ID")
	private Entreprise ent ;
	
    
    @JsonIgnore
	public Collection<Entretien> getEntretiens() {
		return entretiens;
	}
	public void setEntretiens(Collection<Entretien> entretiens) {
		this.entretiens = entretiens;
	}
	
	public Entreprise getEnt() {
		return ent;
	}
	public void setEnt(Entreprise ent) {
		this.ent = ent;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
	
	
	
	

}
