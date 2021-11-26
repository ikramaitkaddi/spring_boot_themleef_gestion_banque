package org.lsi;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.lsi.dao.ClientRepository;
import org.lsi.dao.CompteRepository;
import org.lsi.dao.EmployeRepository;
import org.lsi.dao.GroupeRepository;
import org.lsi.entities.CompteCourant;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.lsi.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication


public class MiniProjetV1Application  implements CommandLineRunner{
	@Autowired
	EmployeRepository employeRepository;
	
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	GroupeRepository groupeRepository;
	public static void main(String[] args)  {
		SpringApplication.run(MiniProjetV1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		

	}

}
