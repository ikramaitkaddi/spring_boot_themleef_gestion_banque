package org.lsi.metier;

import java.util.List;

import org.lsi.entities.Compte;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompteMetier {
	
	public Compte saveCompte(Compte cp);
	public Compte getCompte(String code);
	public void delete(String codeCompte);

}
