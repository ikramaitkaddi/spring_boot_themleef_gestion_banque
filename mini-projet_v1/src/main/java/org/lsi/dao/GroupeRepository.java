package org.lsi.dao;


import org.lsi.entities.Groupe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

	public Page<Groupe> findByNomGroupeContains(String mc, Pageable pageable);
			@Query("select p from Groupe p where p.nomGroupe like :x and p.codeGroupe >:y")
			public Page<Groupe> chercher(@Param("x")String mc,@Param("y")Long codeGroupe, Pageable pageable);
}
