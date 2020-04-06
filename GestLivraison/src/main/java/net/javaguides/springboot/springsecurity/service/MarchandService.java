package net.javaguides.springboot.springsecurity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.exception.RecordNotFoundException;
import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.model.Role;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.repository.ChauffeurRepository;
import net.javaguides.springboot.springsecurity.repository.MarchandRepository;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.web.dto.MarchandRegistrationDto;
import net.javaguides.springboot.springsecurity.web.dto.UserRegistrationDto;

@Service
public class MarchandService  {
	@Autowired
	private MarchandRepository marchandRep;

	public List<Marchand> getAllMarchand() {
		List<Marchand> result = (List<Marchand>) marchandRep.findAll();
		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Marchand>();
		}
		
	}

	
	public Marchand getMarchandById(Long id) throws RecordNotFoundException {
		Optional<Marchand> m = marchandRep.findById(id);

		if (m.isPresent()) {
			return m.get();
		} else {
			throw new RecordNotFoundException("il n'ya pas de marchand avec cet id");
		}

	}

	public Optional<Marchand> findById(Long id) throws RecordNotFoundException {
		return marchandRep.findById(id);
	}



	public Marchand addMarchand(Marchand m) {
		if (m.getId() == null) {
			m = marchandRep.save(m);

			return m;
		} else {
			Optional<Marchand> marchand = marchandRep.findById(m.getId());

			if (marchand.isPresent()) {
				Marchand newEntity = marchand.get();
				newEntity.setNom((m.getNom()));
				newEntity.setPrenom((m.getPrenom()));
				newEntity.setEmail(m.getEmail());
				newEntity.setAdresse(m.getAdresse());
				newEntity.setTel(m.getTel());
	
				return newEntity;
			} else {
				m = marchandRep.save(m);

				return m;
			}

		}
		
	}
	public  Page<Marchand> findByNom(String nom,Pageable pageable)
	{
		return marchandRep.findByNomContainingIgnoreCase(nom, pageable);
		// véhiculerepositry.findByMatriculeContainingIgnoreCase(matricule, pageable);
	}
}