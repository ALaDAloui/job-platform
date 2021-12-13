package com.itgate.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itgate.demo.models.CategorieOffre;

@Repository
public interface ICategorieOffre extends JpaRepository<CategorieOffre, Long>{

}
