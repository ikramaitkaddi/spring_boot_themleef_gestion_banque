package org.lsi.dao;

import java.util.List;

import org.lsi.entities.Compte;
import org.lsi.entities.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompteRepository extends JpaRepository<Compte, String> {
 
	public Page<Compte> findByCodeCompteContains(String mc, Pageable pageable);
	@Query("select p from Compte p where p.codeCompte like :x and p.solde >:y")
	public Page<Compte> chercher(@Param("x")String mc, @Param("y")Long solde, Pageable pageable);
	
	
	@Query("select u from Compte u where u.client.codeClient = :codeClient")
	public List<Compte> findByCodeClient(@Param("codeClient")Long codeClient);
	




}


