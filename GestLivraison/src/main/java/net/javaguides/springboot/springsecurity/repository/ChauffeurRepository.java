package net.javaguides.springboot.springsecurity.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.model.Vehicule;

@Repository
public interface ChauffeurRepository extends  PagingAndSortingRepository<Chauffeur,Long> {
	 Page<Chauffeur>findByNomContainingIgnoreCase(String nom, Pageable pageable);
	/* @Query(
			  value = "SELECT id FROM chauffeur c,user u WHERE u.id = c.id", 
			  nativeQuery = true)
			Collection<Long> findAllIdChauffeur();*/
	 
}
