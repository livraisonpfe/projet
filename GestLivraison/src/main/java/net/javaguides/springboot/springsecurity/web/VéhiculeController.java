package net.javaguides.springboot.springsecurity.web;

import java.lang.ProcessBuilder.Redirect;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import net.javaguides.springboot.springsecurity.service.VéhiculeService;
import net.javaguides.springboot.springsecurity.web.dto.ChauffeurRegistrationDto;
import net.javaguides.springboot.springsecurity.web.dto.VehiculeRegistrationDto;
import net.javaguides.springboot.springsecurity.exception.RecordNotFoundException;
import net.javaguides.springboot.springsecurity.model.Chauffeur;
import net.javaguides.springboot.springsecurity.model.Vehicule;
import net.javaguides.springboot.springsecurity.repository.VéhiculeRepository;

@Controller
@ControllerAdvice
public class VéhiculeController {

	 @Autowired
	 VéhiculeService véhiculeservice;
	 
	 
	 
	  @GetMapping("/vehicule/list")
	    public ModelMap Véhicule(@PageableDefault(size = 5) Pageable pageable, @RequestParam(name = "value", required = false) String value, Model model){
	        if (value != null) {
	            model.addAttribute("key", value);
	            return new ModelMap().addAttribute("vehicules",véhiculeservice.findByMatricule(value, pageable));
	        } else {
	            return new ModelMap().addAttribute("vehicules", véhiculeservice.getAllVéhicule());
	        }
	    }



	    @GetMapping("/vehicule/form")
	    public ModelMap tampilkanForm(@RequestParam(value = "id", required = false)Vehicule vehicule ) {
	    	 if (vehicule == null) {
		        	VehiculeRegistrationDto vehi= new VehiculeRegistrationDto();
		        	return new ModelMap("vehicule", vehi);
		        }
	    	 VehiculeRegistrationDto v= new VehiculeRegistrationDto();
	    	 
	    	 v.setMarque(vehicule.getMarque());
	    	 v.setCapacite(String.valueOf(vehicule.getCapacite()));
	    	 
	    	 v.setMatricule(vehicule.getMatricule());
	    	 v.setId(vehicule.getId());
			       
		        return new ModelMap("vehicule", v);
		    }
	       
	    @PostMapping("/vehicule/form")
	    public String enregistrer(@Valid @ModelAttribute("vehicule") VehiculeRegistrationDto vehiculedto , BindingResult errors, SessionStatus status) {
	    
	    	if(errors.hasErrors())
	    	{
	    		  return "/vehicule/form";
	    	}
	    		Vehicule v=new Vehicule();
	    		v.setCapacite(Float.parseFloat(vehiculedto.getCapacite()));
	    		v.setMarque(vehiculedto.getMarque());
	    		v.setMatricule(vehiculedto.getMatricule());
	    		v.setId(vehiculedto.getId());
	    	  	
	    		 véhiculeservice.addVéhicule(v);
	 	        status.setComplete();
	 	        return "redirect:/vehicule/list";
	    }
	   
	   
	    @GetMapping("/vehicule/delete")
	    public ModelMap deleteConfirm(@RequestParam(value = "id", required = true) Vehicule vehicule,Model m) {
	 Long    id=	vehicule.getId();
	 
	 m.addAttribute("id", id);
	    	return new ModelMap("vehicule", vehicule);
	    }
	    
	 
	   
	   
	@PostMapping("/vehicule/delete")
	    public String delete( @ModelAttribute ("vehicule") Vehicule vehicule,    BindingResult result,ModelMap m) throws RecordNotFoundException  {
	    //String m=	v.getMatricule();
	    Long i=vehicule.getId();
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
	    	m.addAttribute("vehicule", vehicule);
	   	véhiculeservice.deleteVehicule(vehicule);;
	        return "redirect:/vehicule/list";
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
	    
	  
	 
	 
	    