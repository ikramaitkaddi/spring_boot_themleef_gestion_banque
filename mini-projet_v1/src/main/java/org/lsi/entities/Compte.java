package org.lsi.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
	@Type(name="CC",value=CompteCourant.class),
	@Type(name="CE",value=CompteEpargne.class)
})

@Table(name = "compte")
public abstract class Compte implements Serializable {
	
	@Id	
	
	private String codeCompte;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreation;
	private double solde;
	
	@Column(name="TYPE_CPTE" ,insertable=false ,updatable=false)
	public   String type;
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	
	
	public  String getType() {
		return type;
	}
	public void setType(String type) {
	   this.type = type;
	}
	@ManyToOne
	@JoinColumn(name="CODE_EMP")
	private Employe employe;
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
	public Compte(String codeCompte, double solde,Client clt,Employe emp, Date date) {
		super();
		this.codeCompte = codeCompte;
		this.solde = solde;
		this.dateCreation = date;
		this.client= clt;
		this.employe= emp;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	@JsonIgnore
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

}
