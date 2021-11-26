package org.lsi.dao;

import java.util.List;

import org.lsi.entities.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

	public Page<Employe> findByNomEmployeContains(String mc, Pageable pageable);
	@Query("select p from Employe p where p.nomEmploye like :x and p.codeEmploye >:y")
	public Page<Employe> chercher(@Param("x")String mc,
	@Param("y")Long codeEmploye, Pageable pageable);
	
}
