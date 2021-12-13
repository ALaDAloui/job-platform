package com.itgate.demo.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Administrateurs")
public class Administrateur extends User {

	
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
