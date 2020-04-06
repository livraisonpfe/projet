package net.javaguides.springboot.springsecurity.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import net.javaguides.springboot.springsecurity.exception.RecordNotFoundException;
import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.service.ChauffeurService;
import net.javaguides.springboot.springsecurity.service.VéhiculeService;
import net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto;
import net.javaguides.springboot.springsecurity.web.dto.MarchandRegistrationDto;
@Controller
public class ChauffeurController {
	
		 @Autowired
		 ChauffeurService chauffeurService;
		 
		 
		 
		  @GetMapping("/chauffeur/list")
		    public ModelMap Chauffeur(@PageableDefault(size = 5) Pageable pageable, @RequestParam(name = "value", required = false) String value, Model model){
		        if (value != null) {
		            model.addAttribute("key", value);
		            return new ModelMap().addAttribute("chauffeurs",chauffeurService.findByNom(value, pageable));
		        } else {
		            return new ModelMap().addAttribute("chauffeurs", chauffeurService.getAllChauffeur());//addAttribute("ids", chauffeurService.getAllIdchauffeur());
		        }
		    }



		    @GetMapping("/chauffeur/form")
		    public ModelMap tampilkanForm(@RequestParam(value = "id", required = false)Chauffeur chauffeur ) {
		        if (chauffeur == null) {
		        	ChauffeurRegistrationDto chauff= new ChauffeurRegistrationDto();
		        	return new ModelMap("chauffeur", chauff);
		        }
		        ChauffeurRegistrationDto chauff= new ChauffeurRegistrationDto();
		        
		       chauff.setNom( chauffeur.getNom());
		       chauff.setPrenom(( chauffeur.getPassword()));
		       chauff.setNumCin(chauffeur.getCin());
		       chauff.setDateNai(( chauffeur.getDateNai()));
		       chauff.setNumPermi( chauffeur.getNumPermis());
		       chauff.setNumTel(chauffeur.getNumTel());
		       chauff.setLogin( chauffeur.getNomUtilisateur());
		       chauff.setMotPasse(chauffeur.getPassword());
		       chauff.setEtatDispo(chauffeur.getEtatDispo());
		       chauff.setId(chauffeur.getId());
	    		
		       
		       
		        return new ModelMap("chauffeur", chauff);
		    }


		    @PostMapping("/chauffeur/form")
		    public String enregistrer(@Valid @ModelAttribute("chauffeur") ChauffeurRegistrationDto Chauffeurdto , BindingResult errors, SessionStatus status) {
		       /* if (errors.hasErrors()) {
		            return "vehicule/form";
		        }*/
		    	
		    	if(errors.hasErrors())
		    	{
		    		  return "/chauffeur/form";
		    	}
		    		Chauffeur c=new Chauffeur();
		    		c.setNom(Chauffeurdto.getNom());
		    		c.setPrenom(Chauffeurdto.getPrenom());
		    		c.setCin(Chauffeurdto.getNumCin());
		    		c.setDateNai(Chauffeurdto.getDateNai());
		    		c.setNumPermis(Chauffeurdto.getNumPermi());
		    		c.setNumTel((Chauffeurdto.getNumTel()));
		    		c.setNomUtilisateur((Chauffeurdto.getLogin()));
		    		c.setPassword((Chauffeurdto.getMotPasse()));
		    		c.setEtatDispo(Chauffeurdto.getEtatDispo());
		    		c.setId(Chauffeurdto.getId());
		    		
		    	
		    	
		    	
		    	
		    	chauffeurService.addChauffeur(c);
		        status.setComplete();
		        return "redirect:/chauffeur/list";
		    }




		 /*   @GetMapping("/vehicule/delete/{id}")
		    public String deleteConfirm(@PathVariable("id") Long id ,ModelMap map) throws RecordNotFoundException {
		    	
		    Optional<net.javaguides.springboot.springsecurity.model.Véhicule> v=	véhiculeservice.findById(id);
		    	map.addAttribute("vehicule",v);
		    	
		        //return new ModelMap("vehicule", vehicule);
		    	return "vehicule/delete";
		    }*/
		
		   
		   
		    @GetMapping("/chauffeur/delete")
		    public ModelMap deleteConfirm(@RequestParam(value = "id", required = true) Chauffeur chauffeur,Model m) {
		 Long    id=	chauffeur.getId();
		 
		 m.addAttribute("id", id);
		    	return new ModelMap("chauffeur", chauffeur);
		    }
		    
		 
		   
		   
		@PostMapping("/chauffeur/delete")
		    public String delete( @ModelAttribute ("chauffeur") Chauffeur chauffeur,    BindingResult result,ModelMap m) throws RecordNotFoundException  {
		    //String m=	v.getMatricule();
		    Long i=chauffeur.getId();
		  //  véhiculeservice.deleteVéhiculeById(i);;
		    //v.setId(id);
		    //System.out.print(id);
		    /*	if(v==null)
		    	{
		    		m.addAttribute("msg","ooooo");
		    	}
		    	else { m.addAttribute("msg","eyyyy");}*/
			//m.addAttribute("matricule", vehicule.getMatricule());
	       // m.addAttribute("id", employee.getId());
		    	m.addAttribute("chauffeur", chauffeur);
		    	chauffeurService.deleteChauffeur(
		    			chauffeur);
		        return "redirect:/chauffeur/list";
		        //return "redirect:/vehicule/list";
		    }
		   /* @RequestMapping("/vehicule/delete")
		    public String hapus (@RequestParam("id") Long id) throws RecordNotFoundException{
		    	véhiculeservice.deleteVéhiculeById(id);;
		        return "redirect:list";
		    }*/
		    
		    
	}

		    /*@PostMapping("/vehicule/delete/{id}")
		    public String  delete(@RequestParam("id") Long id , SessionStatus status) throws RecordNotFoundException 
		    	{ 	 //véhiculeservice.deleteVéhiculeById(id);
		    	Optional<net.javaguides.springboot.springsecurity.model.Véhicule> v=	véhiculeservice.findById(id);
		    		       
		 véhiculeservice.deleteVehicule(v);
		    status.setComplete();
	        return "redirect:/vehicule/list";}
		    }*/
		    
		    
		    	//catch (DataIntegrityViolationException exception) {
		          //  status.setComplete();
		         /*   return new ModelAndView("error/errorHapus")
		                    .addObject("entityId", vehicule.getMatricule())
		                    .addObject("entityName", "Vehicule")
		                    .addObject("errorCause", exception.getRootCause().getMessage())
		                    .addObject("backLink","/karyawan/list");
		        }*/
		     //   status.setComplete();
		     //   return "redirect:/vehicule/list";
		 
		    	
		    /*catch (DataIntegrityViolationException exception) {
		    	status.setComplete();
	}
	status.setComplete();
	return "redirect:/karyawan/list";

		        
		       return "redirect:/vehicule/list";*/
		    
		  
		 


