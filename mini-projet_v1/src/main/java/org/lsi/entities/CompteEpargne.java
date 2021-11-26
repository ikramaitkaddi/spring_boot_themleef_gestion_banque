package org.lsi.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")

public class CompteEpargne extends Compte {
	
	
	private double taux;
	
	public  CompteEpargne() {
		super();
		
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public CompteEpargne(String codeCompte,  double solde,Client clt,Employe emp,Date date, double taux) {
		super(codeCompte, solde,clt,emp,date);
		this.taux = taux;
		this.type = "CE";
		
	}

	

}
