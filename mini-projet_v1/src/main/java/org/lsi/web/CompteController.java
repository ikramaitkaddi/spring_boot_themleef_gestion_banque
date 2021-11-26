package org.lsi.web;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.lsi.dao.ClientRepository;
import org.lsi.dao.CompteRepository;
import org.lsi.dao.EmployeRepository;
import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Client;
import org.lsi.entities.Compte;
import org.lsi.entities.Employe;
import org.lsi.metier.CompteMetier;
import org.lsi.entities.CompteCourant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CompteController {

	@Autowired
	private CompteRepository compteRepository;
	
	/*@Autowired
	public CompteMetier compteMetier;*/
	
     
	@GetMapping(path="/comptes")
	private String comptes(Model model,
	 @RequestParam(name="page",defaultValue ="0")int page,
	 @RequestParam(name="size",defaultValue="10")int size,
	 @RequestParam(name="motCle",defaultValue="")String motCle
	 ){
		
	 Page<Compte> pageComptes = compteRepository.findByCodeCompteContains(motCle,PageRequest.of(page,size));
	 model.addAttribute("pageComptes",pageComptes);
	 model.addAttribute("currentPage", page);
	 model.addAttribute("size", size);
	 model.addAttribute("motCle", motCle);
	 model.addAttribute("pages", new int[ pageComptes.getTotalPages()]);
	 return "comptes";
	 }
	

	
	@GetMapping(path="/compteC")
	private String compteC(Model model,String codeCompte, double decouvert,String date,double solde,Long codeClient, String nomEmploye , Long codeEmploye) {
		 model.addAttribute("codeCompte",codeCompte);
		 model.addAttribute("decouvert", decouvert);
		 model.addAttribute("date", date);
		 model.addAttribute("solde", solde);
		 model.addAttribute("codeClient", codeClient);
		 model.addAttribute("nomEmploye", nomEmploye);
		 model.addAttribute("codeEmploye", codeEmploye);
	 return "compteC";
	 }
	@GetMapping(path="/compteE")
	private String compteE(Model model,String codeCompte, double taux,String date,double solde,Long codeClient, String nomEmploye,Long codeEmploye) {
		 model.addAttribute("codeCompte",codeCompte);
		 model.addAttribute("taux", taux);
		 model.addAttribute("date", date);
		 model.addAttribute("solde", solde);
		 model.addAttribute("codeClient", codeClient);
		 model.addAttribute("codeEmploye", codeEmploye);
		 model.addAttribute("nomEmploye", nomEmploye);
	 return "compteE";
	 }

}
