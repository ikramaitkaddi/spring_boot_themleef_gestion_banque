package org.lsi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
@Entity
@Table(name = "groupe")
public class Groupe implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long codeGroupe;
	private String nomGroupe;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="EMP_GR")
	private Collection<Employe> employe;
	
	public Groupe(String nomGroupe) {
		super();
		
		this.nomGroupe = nomGroupe;
	   
	}
	
	
	@Override
	public String toString() {
	return "groupe [codeGroupe=" + codeGroupe + ", nomGroupe=" + nomGroupe + "]";
	}
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCodeGroupe() {
		return codeGroupe;
	}
	public void setCodeGroupe(Long codeGroupe) {
		this.codeGroupe = codeGroupe;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	public Collection<Employe> getEmploye() {
		return employe;
	}
	public void setEmploye(Collection <Employe> employe) {
		this.employe = employe;
	}

}
