package com.itgate.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.Entreprise;

@Repository
public interface IEntreprise extends JpaRepository<Entreprise, Long> {

}
