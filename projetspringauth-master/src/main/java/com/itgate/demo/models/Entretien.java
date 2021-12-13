package com.itgate.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.aggregation.StringOperators.Concat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
allowGetters = true)
public class Entretien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateEntretien ;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh-mm AA")
	private String time ;
	private String accepte ;
	private String lienEntretien;
	
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "CANDIDAT_ID")
    private Candidat c;
    
    @ManyToOne
    @JoinColumn(name = "ENTREPRISE_ID")
    private Entreprise entr ;
    
    @ManyToOne
    @JoinColumn(name = "CANDIDATURE_ID")
    private Candidature didature;
    
    @ManyToOne
	@JoinColumn(name = "RECRUTEUR_ID")
	private Recruteur r ;

    
    
    public Candidature getDidature() {
		return didature;
	}

	public void setDidature(Candidature didature) {
		this.didature = didature;
	}

	public Entreprise getEntr() {
		return entr;
	}

	public void setEntr(Entreprise entr) {
		this.entr = entr;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Candidat getC() {
		return c;
	}

	public void setC(Candidat c) {
		this.c = c;
	}

	public Recruteur getR() {
		return r;
	}

	public void setR(Recruteur r) {
		this.r = r;
	}

	public String getLienEntretien() {
		return lienEntretien;
	}

	public void setLienEntretien(String lienEntretien) {
		this.lienEntretien = lienEntretien;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateEntretien() {
		return dateEntretien;
	}

	public void setDateEntretien(Date dateEntretien) {
		this.dateEntretien = dateEntretien;
	}

	public String getAccepte() {
		return accepte;
	}

	public void setAccepte(String accepte) {
		this.accepte = accepte;
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
    
    
    

}
