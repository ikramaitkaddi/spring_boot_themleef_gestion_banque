package org.lsi.web;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lsi.dao.ClientRepository;
import org.lsi.dao.CompteRepository;
import org.lsi.dao.EmployeRepository;
import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Client;
import org.lsi.entities.Compte;
import org.lsi.entities.CompteCourant;
import org.lsi.entities.CompteEpargne;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.lsi.metier.ClientMetier;
import org.lsi.metier.CompteMetier;
import org.lsi.metier.EmployeMetier;
import org.lsi.metier.OperationMetier;
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
public class CompteCourantController {

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private EmployeMetier employeMetier;
	@Autowired
	private ClientMetier clientMetier;
	@Autowired
	private OperationMetier operationMetier;

	@GetMapping(path = "/saveCompteCourant")
	private String saveCompte(@RequestParam(name = "codeCompte", defaultValue = "") String codeCompte,
			@RequestParam(name = "codeClient", defaultValue = "") Long codeClient,
			@RequestParam(name = "solde", defaultValue = "") double solde,
			@RequestParam(name = "emp", defaultValue = "") Long emp,
			@RequestParam(name = "decouvert", defaultValue = "") double decouvert) {

		System.out.println(" hello save " + clientRepository.existsById(codeClient));
		if (clientMetier.existCientId(codeClient)) {
			if (!compteRepository.existsById(codeCompte)) {
				System.out.println(clientRepository.findById(codeClient));
				System.out.println("in save 2" + codeClient);

				Employe employ = employeMetier.getEmployeById(emp);

				Client clientt = clientMetier.getClientById(codeClient);

				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				System.out.println(date);

				compteRepository
						.save(new CompteCourant(codeCompte, solde + decouvert, clientt, employ, date, decouvert));

				return "redirect:/comptes";
			} else {
				return "erreur";
			}
		} else {
			return "erreur";
		}
	}

	@GetMapping(path = "/compteCourant")
	private String compteCourant(Model model) {

		List<Employe> listEmployes = employeMetier.listEmployes();

		model.addAttribute("listEmployes", listEmployes);
		model.addAttribute("employe", new Employe());

		return "compteCourant";
	}

	@GetMapping(path = "/retirerCompteC")
	private String retirerCompteC(@RequestParam(name = "somme", defaultValue = "") double somme, String codeCompte,
			double decouvert, String date, double solde, Long codeClient, String nomEmploye, Long codeEmploye) {

		System.out.println("somme à retirer : " + somme + "code " + codeCompte);
		Compte cpt = compteRepository.getById(codeCompte);
		if (cpt.getSolde() < somme) {
			return "soldeInsuffisant";
		}

		operationMetier.retirer(codeCompte, somme, codeEmploye);
		return "redirect:/comptes";
	}

	@GetMapping(path = "/verserCompteC")
	private String verserCompteC(@RequestParam(name = "somme", defaultValue = "") double somme, String codeCompte,
			double decouvert, String date, double solde, Long codeClient, String nomEmploye, Long codeEmploye) {

		System.out.println("somme à verser : " + somme + "code " + codeCompte);

		operationMetier.verser(codeCompte, somme, codeEmploye);
		return "redirect:/comptes";
	}

	@GetMapping(path = "/vererCompteC")
	private String vererCompteC(@RequestParam(name = "somme", defaultValue = "") double somme, String codeCompte,
			double decouvert, String date, double solde, Long codeClient, String nomEmploye, Long codeEmploye,
			String code) {

		System.out.println("somme à verser : " + somme + "code " + codeCompte);

		Compte cpt = compteRepository.getById(codeCompte);
		Compte cp = compteRepository.getById(code);
		if (compteRepository.existsById(code)) {

			if (cpt.getSolde() < somme) {
				return "soldeInsuffisant";
			}
			operationMetier.virement(codeCompte, code, somme, codeEmploye);
			return "redirect:/comptes";
		} else
			return "erreur";
	}

}
