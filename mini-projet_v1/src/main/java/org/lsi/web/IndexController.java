package org.lsi.web;

import org.lsi.dao.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	
	
	@GetMapping(path="/index")
	private String index() {
	 return "index";
	 }
	
	
	
}
