package com.itgate.demo.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itgate.demo.models.exam.Exam;

@Entity
public class Candidat extends User {
	
	
	 
	private String adresse;
	private int code_postal;
	private String location;
	private String niveau ;
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String dateNaissance ;
	private String email;
	private int telephone ;
	private String about;
	private String skills;
	
	@OneToMany(mappedBy = "ca")
	private Collection<Candidature> candidatures;
	
	@OneToMany(mappedBy = "c")
	private Collection<Entretien> entretiens ; 

	
	
	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam ex;
	
	
 
	
	@OneToMany(mappedBy = "can")
	private Collection<Experience> experiences;
	
	@OneToMany(mappedBy = "cand")
	private Collection<Formation> formations;
	
	
	public Exam getEx() {
		return ex;
	}

	public void setEx(Exam ex) {
		this.ex = ex;
	}
	@OneToMany(mappedBy = "candidat")
    private Collection<ListFavorite > listefavorites;
    @JsonIgnore
    public Collection<ListFavorite> getListefavorites() {
        return listefavorites;
    }

    public void setListefavorites(Collection<ListFavorite> listefavorites) {
        this.listefavorites = listefavorites;
    }

    
	@JsonIgnore
	public Collection<Formation> getFormations() {
		return formations;
	}
	public void setFormations(Collection<Formation> formations) {
		this.formations = formations;
	}
	@JsonIgnore
	public Collection<Candidature> getCandidatures() {
		return candidatures;
	}
	public void setCandidatures(Collection<Candidature> candidatures) {
		this.candidatures = candidatures;
	}
	@JsonIgnore
	public Collection<Entretien> getEntretiens() {
		return entretiens;
	}
	public void setEntretiens(Collection<Entretien> entretiens) {
		this.entretiens = entretiens;
	}
	
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	@JsonIgnore
	public Collection<Experience> getExperiences() {
		return experiences;
	}
	public void setExperiences(Collection<Experience> experiences) {
		this.experiences = experiences;
	}
	
	
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
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
