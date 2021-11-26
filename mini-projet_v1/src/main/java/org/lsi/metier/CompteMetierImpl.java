package org.lsi.metier;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.lsi.dao.CompteRepository;
import org.lsi.entities.Client;
import org.lsi.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public abstract class CompteMetierImpl implements CompteMetier {
	
	
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte cp) {
		// TODO Auto-generated method stub
		cp.setDateCreation(new Date());
		return compteRepository.save(cp);
	}

	@Override
	public Compte getCompte(String code) {
		// TODO Auto-generated method stub
		return compteRepository.findById(code).orElse(null);
	}

	@Override
	public void delete(String codeCompte) {
	
	}


	

}
