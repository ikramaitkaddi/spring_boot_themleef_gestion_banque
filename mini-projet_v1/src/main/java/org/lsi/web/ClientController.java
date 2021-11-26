package org.lsi.web;


import java.util.List;

import org.lsi.dao.ClientRepository;
import org.lsi.dao.CompteRepository;
import org.lsi.dao.EmployeRepository;
import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Client;
import org.lsi.entities.Compte;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.lsi.metier.ClientMetier;
import org.lsi.metier.CompteMetier;
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
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CompteRepository compteRepository;
	
	
	@Autowired
	public ClientMetier clientMetier;
	
	@GetMapping(path="/saveClient")
	private String saveClient( @RequestParam(name="nomClient",defaultValue="")String nomClient  
			            ) {
     System.out.println("in save");
  
     clientMetier.saveClient(new Client(nomClient));

     return "redirect:/clients";
	 }
	
     
	@GetMapping(path="/clients")
	private String clients(Model model,
	 @RequestParam(name="page",defaultValue ="0")int page,
	 @RequestParam(name="size",defaultValue="10")int size,
	 @RequestParam(name="motCle",defaultValue="")String motCle
	 ){
	
	 Page<Client> pageClients = clientRepository.findByNomClientContains(motCle,PageRequest.of(page,size));
	 model.addAttribute("pageClients", pageClients);
	 model.addAttribute("currentPage", page);
	 model.addAttribute("size", size);
	 model.addAttribute("motCle", motCle);
	 model.addAttribute("pages", new int[pageClients.getTotalPages()]);
	 return "clients";
	 }

	@GetMapping(path="/comptesClient")
	private String comptesClient(Model model,Long codeClient){
		
		 List<Compte> listComptesClient = compteRepository.findByCodeClient(codeClient);
		 model.addAttribute("listComptesClient", listComptesClient);
		 model.addAttribute("codeClient", codeClient);
	 return "comptesClient";
}
}
