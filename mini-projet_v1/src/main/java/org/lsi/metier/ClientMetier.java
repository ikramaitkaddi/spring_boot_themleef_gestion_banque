package org.lsi.metier;

import java.util.List;

import org.lsi.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ClientMetier {

	public Client saveClient(Client c);
	public List<Client> listClient();
	public void delete(Long codeClient);
	public Client getClientById(Long c);
	public boolean existCientId(Long p);
}


