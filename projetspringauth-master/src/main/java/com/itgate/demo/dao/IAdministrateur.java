package com.itgate.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itgate.demo.models.Administrateur;

public interface IAdministrateur extends JpaRepository<Administrateur, Long>{

}
