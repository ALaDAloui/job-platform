package com.itgate.demo.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itgate.demo.models.Enum.Status;
import com.itgate.demo.models.exam.Exam;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
allowGetters = true)
public class OffreEmploi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titre;
	private String description;
	private String connaissance_technique ;
	private String competence ;
	private int nbrPoste ; 

	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
	private String typeContrat;
	private String salaire;
	private String region;
	private String niveauEtudes ;
	private String experience ;
	private String typeemploi ;
	
	
	
	private String status;

	@OneToMany(mappedBy = "ee")
	private Collection<Notification> notifications;
	
	
	@ManyToOne
	@JoinColumn(name = "Entreprise_ID")
	private Entreprise e ;
	
	@OneToMany(mappedBy = "ofe")
	private Collection<Candidature> candidatures;
	
	@OneToMany(mappedBy = "of")
	private Collection<Exam> exams ;
	
	@ManyToOne
	@JoinColumn(name = "CATEGORIE_ID")
	private CategorieOffre co; 
	
	@OneToMany(mappedBy = "o")
	private Collection<Commentaire> commentaires;
	

	@JsonIgnore
	  public Collection<Exam> getExams() {
		return exams;
	}
	public void setExams(Collection<Exam> exams) {
		this.exams = exams;
	}
	@OneToMany(mappedBy = "offres")
	    private Collection<ListFavorite> listefavorites;
	    @JsonIgnore
	    public Collection<ListFavorite> getListefavorites() {
	        return listefavorites;
	    }
	    public void setListefavorites(Collection<ListFavorite> listefavorites) {
	        this.listefavorites = listefavorites;
	    }
	

	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Entreprise getE() {
		return e;
	}
	public void setE(Entreprise e) {
		this.e = e;
	}
	@JsonIgnore
	public Collection<Candidature> getCandidatures() {
		return candidatures;
	}
	public void setCandidatures(Collection<Candidature> candidatures) {
		this.candidatures = candidatures;
	}
	@JsonIgnore
	public Collection<Exam> getTests() {
		return exams;
	}
	public void setTests(Collection<Exam> exams) {
		this.exams = exams;
	}
	public CategorieOffre getCo() {
		return co;
	}
	public void setCo(CategorieOffre co) {
		this.co = co;
	}
	@JsonIgnore
	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	
	public String getTypeemploi() {
		return typeemploi;
	}
	public void setTypeemploi(String typeemploi) {
		this.typeemploi = typeemploi;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompetence() {
		return competence;
	}
	public void setCompetence(String competence) {
		this.competence = competence;
	}
	public int getNbrPoste() {
		return nbrPoste;
	}
	public void setNbrPoste(int nbrPoste) {
		this.nbrPoste = nbrPoste;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	
	public String getSalaire() {
		return salaire;
	}
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getConnaissance_technique() {
		return connaissance_technique;
	}
	public void setConnaissance_technique(String connaissance_technique) {
		this.connaissance_technique = connaissance_technique;
	}
	public String getNiveauEtudes() {
		return niveauEtudes;
	}
	public void setNiveauEtudes(String niveauEtudes) {
		this.niveauEtudes = niveauEtudes;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}

	
	
	
	
	
	

}
