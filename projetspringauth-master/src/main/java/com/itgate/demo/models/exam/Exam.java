package com.itgate.demo.models.exam;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
import com.itgate.demo.models.Entreprise;
import com.itgate.demo.models.OffreEmploi;
import com.itgate.demo.models.Recruteur;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.CategorieOffre;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
allowGetters = true)
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long exId;

	private String title;

	@Column(length = 5000)
	private String description;

	private String maxMarks;

	private String numberOfQuestions;
	
	
	private boolean active = false;
	
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
    
    

	@OneToMany(mappedBy = "exam")
	private Collection<Question> questions;

	
	
	@OneToMany(mappedBy = "ex")
	private Collection<Candidat> users;
    
    @ManyToOne
	@JoinColumn(name = "Offre_ID")
	private OffreEmploi of ;
	
    
    @ManyToOne
  	@JoinColumn(name = "Entreprise_ID")
  	private Entreprise en ;
   
     
    
    public Exam() {

	}




	public Entreprise getEn() {
		return en;
	}


	public void setEn(Entreprise en) {
		this.en = en;
	}


	public Long getExId() {
		return exId;
	}


	public void setExId(Long exId) {
		this.exId = exId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getMaxMarks() {
		return maxMarks;
	}


	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}


	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}


	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	@JsonIgnore 
	public Collection<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
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



	@JsonIgnore 
	public Collection<Candidat> getUsers() {
		return users;
	}


	public void setUsers(Collection<Candidat> users) {
		this.users = users;
	}


	public OffreEmploi getOf() {
		return of;
	}


	public void setOf(OffreEmploi of) {
		this.of = of;
	}


	
    
    

}
