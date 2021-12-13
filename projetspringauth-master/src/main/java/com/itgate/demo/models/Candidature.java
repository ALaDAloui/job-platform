package com.itgate.demo.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
public class Candidature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ; 
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;	
	
	
	 private String name;
     private String url;
	 private String email;
	 private String etat;
	 private String note;
	 
	 

	  
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	@ManyToOne
	@JoinColumn(name = "Offre_ID")
	private OffreEmploi ofe;
	
	@ManyToOne
	@JoinColumn(name = "Candidat_ID")
	private Candidat ca;
	
	@OneToMany(mappedBy = "didature")
	private Collection<Entretien> entretiens;
	
	
	
	@JsonIgnore
	public Collection<Entretien> getEntretiens() {
		return entretiens;
	}
	public void setEntretiens(Collection<Entretien> entretiens) {
		this.entretiens = entretiens;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public OffreEmploi getOfe() {
		return ofe;
	}
	public void setOfe(OffreEmploi ofe) {
		this.ofe = ofe;
	}
	public Candidat getCa() {
		return ca;
	}
	public void setCa(Candidat ca) {
		this.ca = ca;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
	

}
