package org.lsi.metier;

import java.util.List;

import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;

public interface GroupeMetier {
	
	public Groupe saveGroupe(Groupe e);
	public List<Groupe> listGroupe();
	public void delete(Long codeGroupe);

}
