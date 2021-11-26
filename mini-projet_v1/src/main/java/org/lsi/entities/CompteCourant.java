package org.lsi.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")

public class CompteCourant extends Compte {
	
	/*public CompteCourant(String codeCompte, Date dateCreation, double solde, Client client, Employe employe) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
		this.employe = employe;
		this.codeCompte = codeCompte;
	}*/
	
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
    
	private double decouvert;

	public CompteCourant(String codeCompte,  double solde,Client clt,Employe emp,Date date, double decouvert) {
		super(codeCompte, solde,clt,emp,date);
		this.decouvert = decouvert;
	 
	   
	}

	public CompteCourant() {
		super();
		
	}

	
}
