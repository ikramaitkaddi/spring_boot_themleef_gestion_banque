package org.lsi.metier;

import java.util.List;

import org.lsi.dao.ClientRepository;
import org.lsi.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public  class ClientMetierImpl implements ClientMetier {
	
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client saveClient(Client c) {
		// TODO Auto-generated method stub
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public void delete(Long codeClient) {
		// TODO Auto-generated method stub
		 clientRepository.deleteById(codeClient);
		
	}

	@Override
	public Client getClientById(Long c) {
		// TODO Auto-generated method stub
		return clientRepository.getById(c) ;
	}

	@Override
	public boolean existCientId(Long p) {
		// TODO Auto-generated method stub
		return clientRepository.existsById(p) ;
	}





	
	

	

}
