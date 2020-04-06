package net.javaguides.springboot.springsecurity.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.exception.RecordNotFoundException;
import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.Vehicule;
import net.javaguides.springboot.springsecurity.repository.ChauffeurRepository;

@Service
public class ChauffeurService {
@Autowired
private ChauffeurRepository chauffeurrepositry;

public List<Chauffeur> getAllChauffeur() {
List<Chauffeur> result = (List<Chauffeur>) chauffeurrepositry.findAll();
if (result.size() > 0) {
return result;
} else {
return new ArrayList<Chauffeur>();
}
/*
* repositrytodo.findAll().forEach(data::add); return data;
*/
}


/* public List<Long>  getAllIdchauffeur()
{ List<Long> ids =  (List<Long>) chauffeurrepositry.findAllIdChauffeur();

if (ids.size() > 0) {
return ids;
} else {
return new ArrayList<Long>();
}
}*/
public Chauffeur getChauffeurById(Long id) throws RecordNotFoundException {
Optional<Chauffeur> c = chauffeurrepositry.findById(id);

if (c.isPresent()) {
return c.get();
} else {
throw new RecordNotFoundException("il n'ya pas de chauffeur avec cet id");
}

}

public Optional<Chauffeur> findById(Long id) throws RecordNotFoundException {
return chauffeurrepositry.findById(id);
}

public void deleteChauffeur(Chauffeur v) // throws RecordNotFoundException
{
chauffeurrepositry.delete(v);

}

public void deleteChauffeurById(Long id) {
Optional<Chauffeur> vehicule = chauffeurrepositry.findById(id);

chauffeurrepositry.deleteById(id);
/*
* } else { throw new
* RecordNotFoundException("il n'ya pas de véhicule avec cet id"); }
*/
}

public Chauffeur addChauffeur(Chauffeur c) {
if (c.getId() == null) {
c = chauffeurrepositry.save(c);

return c;
} else {
Optional<Chauffeur> chauffeur = chauffeurrepositry.findById(c.getId());

if (chauffeur.isPresent()) {
Chauffeur newEntity = chauffeur.get();
newEntity.setNom((c.getNom()));
newEntity.setPrenom((c.getPrenom()));
newEntity.setDateNai(c.getDateNai());
newEntity.setEmail((c.getEmail()));
newEntity.setEtatDispo(c.getEtatDispo());
newEntity.setCin(c.getCin());
newEntity.setNumPermis(c.getNumPermis());
newEntity.setNumTel(c.getNumTel());
newEntity = chauffeurrepositry.save(newEntity);

return newEntity;
} else {
c = chauffeurrepositry.save(c);

return c;
}

}

}
public  Page<Chauffeur> findByNom(String nom,Pageable pageable)
{
return chauffeurrepositry.findByNomContainingIgnoreCase(nom, pageable);
// véhiculerepositry.findByMatriculeContainingIgnoreCase(matricule, pageable);
}
}

