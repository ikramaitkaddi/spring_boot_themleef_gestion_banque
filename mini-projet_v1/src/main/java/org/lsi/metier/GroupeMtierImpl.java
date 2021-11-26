package org.lsi.metier;

import java.util.List;

import org.lsi.dao.EmployeRepository;
import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class GroupeMtierImpl implements GroupeMetier {
	
	@Autowired
	private GroupeRepository  groupeRepository;

	@Override
	public Groupe saveGroupe(Groupe e) {
		// TODO Auto-generated method stub
		return groupeRepository.save(e);
	}

	@Override
	public List<Groupe> listGroupe() {
		// TODO Auto-generated method stub
		return groupeRepository.findAll();
	}
	@Override
	public void delete(Long codeGroupe) {
		// TODO Auto-generated method stub
		 groupeRepository.deleteById(codeGroupe);
		
	}


}
