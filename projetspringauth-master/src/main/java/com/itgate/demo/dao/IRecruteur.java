package com.itgate.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Recruteur;

@Repository
public interface IRecruteur extends JpaRepository<Recruteur, Long>{

}
