package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import net.javaguides.springboot.springsecurity.model.Marchand;


public interface MarchandRepository extends PagingAndSortingRepository<Marchand,Long> {
	 Page<Marchand>findByNomContainingIgnoreCase(String nom, Pageable pageable);
	 
	 
}