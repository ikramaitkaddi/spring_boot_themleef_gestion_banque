package org.lsi.web;


import java.util.List;

import org.lsi.dao.EmployeRepository;
import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.lsi.metier.EmployeMetier;
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
public class EmployeController {

	@Autowired
	private EmployeRepository employeRepository;
   
	@Autowired
	private EmployeMetier employeMetier;
	
	
	@GetMapping(path="/saveEmploye")
	private String saveEmploye(Model model, @RequestParam(name="codeEmploye",defaultValue="") Long  codeEmploye, 
			             @RequestParam(name="nomEmploye",defaultValue="")String nomEmploye,
			             @RequestParam(name="emp",defaultValue="")Long emp
			            ) {
     System.out.println("in save" + emp);
     Employe employ= employeMetier.getEmployeById(emp);
     employeMetier.saveEmploye(new Employe(codeEmploye,nomEmploye,employ));

     return "redirect:/employes";
	 }
	
     
	@GetMapping(path="/employes")
	private String employes(Model model,
	 @RequestParam(name="page",defaultValue ="0")int page,
	 @RequestParam(name="size",defaultValue="10")int size,
	 @RequestParam(name="motCle",defaultValue="")String motCle
	 ){
		List<Employe> listEmployes =employeMetier.listEmployes();
	     model.addAttribute("listEmployes", listEmployes);
	     model.addAttribute("employe", new Employe());
	 Page<Employe> pageEmployes = employeRepository.findByNomEmployeContains(motCle,PageRequest.of(page,size));
	 model.addAttribute("pageEmployes", pageEmployes);
	 model.addAttribute("currentPage", page);
	 model.addAttribute("size", size);
	 model.addAttribute("motCle", motCle);
	 model.addAttribute("pages", new int[pageEmployes.getTotalPages()]);
	 return "employes";
	 }
	@GetMapping(path="/deleteEmploye")
	private String delete(Long codeEmploye,String motCle, String page, String size) {

	employeMetier.delete(codeEmploye);
	return "redirect:/employes";
	 }
}
