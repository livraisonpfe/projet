package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Vehicule;


@Repository
public interface VéhiculeRepository extends  PagingAndSortingRepository<Vehicule,Long> {
	 Page<Vehicule>findByMatriculeContainingIgnoreCase(String maricule, Pageable pageable);
	 
	 
}
