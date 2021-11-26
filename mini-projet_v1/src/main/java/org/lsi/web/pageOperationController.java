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
import org.lsi.entities.Operation;
import org.lsi.metier.CompteMetier;
import org.lsi.metier.OperationMetier;
import org.lsi.metier.PageOperation;
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
public class pageOperationController {

	@Autowired
	private  OperationMetier operationMetier;
	/*@Autowired
	public CompteMetier compteMetier;*/
	
     
	@GetMapping(path="/pageOperation")
	private String comptes(Model model,String codeCompte,
	 @RequestParam(name="page",defaultValue ="0")int page,
	 @RequestParam(name="size",defaultValue="10")int size
	 ){
		System.out.println(codeCompte);
		
   PageOperation pageOperation = operationMetier.getOperation(codeCompte,page,size);
	 model.addAttribute("pageOperation",pageOperation);
	 model.addAttribute("currentPage", page);
	 model.addAttribute("size", size);
	 model.addAttribute("codeCompte", codeCompte);
	 model.addAttribute("pages", new int[  pageOperation.getTotalpages()]);
	 return "pageOperation";
	 }
	
	

}
