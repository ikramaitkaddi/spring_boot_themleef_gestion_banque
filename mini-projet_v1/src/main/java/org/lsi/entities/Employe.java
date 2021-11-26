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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity

public class Employe implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long codeEmploye;
	private String nomEmploye;
	
	@ManyToOne
	@JoinColumn(name="code_emp_sup")
	private Employe employeSup; 
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,  mappedBy="employe")
	
	//@JoinTable(name = "EMP_GR",joinColumns = { @JoinColumn(name = "employe_code_employe")},inverseJoinColumns = { @JoinColumn (name = "groupes_code_groupe")})
	private Set<Groupe> groupes =  new HashSet<>();
	
	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}
	
	public Employe(Long codeEmploye, String nomEmploye, Employe employeSup) {
		super();
		this.codeEmploye = codeEmploye;
		this.nomEmploye = nomEmploye;
		this.employeSup = employeSup;
	}

	public Employe(Long codeEmploye, String nomEmploye) {
		super();
		this.codeEmploye = codeEmploye;
		this.nomEmploye = nomEmploye;
	}
	

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	@JsonIgnore
	public Employe getEmployeSup() {
		return employeSup;
	}
	@JsonSetter
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}
	@JsonIgnore
	public Set<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Set <Groupe> groupes) {
		this.groupes = groupes;
	}

}
