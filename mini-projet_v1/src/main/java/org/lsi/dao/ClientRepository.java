package org.lsi.dao;


import org.lsi.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {

	public Page<Client> findByNomClientContains(String mc, Pageable pageable);
	@Query("select p from Client p where p.nomClient like :x and p.codeClient >:y")
	public Page<Client> chercher(@Param("x")String mc,
	@Param("y")Long codeClient, Pageable pageable);
}
