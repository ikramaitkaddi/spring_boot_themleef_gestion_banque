package org.lsi.web;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lsi.dao.EmployeRepository;
import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Compte;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.lsi.metier.ClientMetier;
import org.lsi.metier.EmployeMetier;
import org.lsi.metier.GroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GroupeController {

	@Autowired
	private GroupeRepository groupeRepository;
	@Autowired
	private EmployeRepository employeRepository;
	
	@Autowired
	public GroupeMetier groupeMetier;
	@Autowired
	public EmployeMetier employeMetier;
	
	@PostMapping(path="/saveGroupe")
	private String saveGroupe(@ModelAttribute("groupe") Groupe groupe) {
     System.out.println("hello in save " +groupe.getEmploye());
     Groupe grp = new Groupe(groupe.getNomGroupe());
      grp.setEmploye(groupe.getEmploye());
 
     for(Employe e :grp.getEmploye()){
 	    System.out.println("hello in save grp element : "  +  e.getNomEmploye());
 	 
  }
    
     groupeMetier.saveGroupe(groupe);
     return "redirect:/groupes";
	 }
	
	@GetMapping(path="/groupes")
	private String groupes(Model model,
	 @RequestParam(name="page",defaultValue ="0")int page,
	 @RequestParam(name="size",defaultValue="10")int size,
	 @RequestParam(name="motCle",defaultValue="")String motCle
	 ){
		List<Employe> listEmployes = employeMetier.listEmployes();
		
	     model.addAttribute("listEmployes", listEmployes);
	     model.addAttribute("employe", new Employe());
	     model.addAttribute("groupe", new Groupe());
	 Page<Groupe>
	pageGroupes = groupeRepository.findByNomGroupeContains(motCle,PageRequest.of(page,size));
	 model.addAttribute("pageGroupes", pageGroupes);
	 model.addAttribute("currentPage", page);
	 model.addAttribute("size", size);
	 model.addAttribute("motCle", motCle);
	 model.addAttribute("pages", new int[pageGroupes.getTotalPages()]);
	 return "groupes";
	 }

}
