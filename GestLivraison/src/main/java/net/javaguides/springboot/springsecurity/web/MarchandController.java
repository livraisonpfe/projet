package net.javaguides.springboot.springsecurity.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import net.javaguides.springboot.springsecurity.exception.RecordNotFoundException;
import net.javaguides.springboot.springsecurity.model.Marchand;
import net.javaguides.springboot.springsecurity.service.ChauffeurService;
import net.javaguides.springboot.springsecurity.service.MarchandService;

@Controller
public class MarchandController {
	 @Autowired
	 MarchandService marchandService;
		 @GetMapping(value = "/marchand/list")
		 public String allParachiot(Model model) {
		      
		     model.addAttribute("marchands", marchandService.getAllMarchand());
		      
		     return "/marchand/list";
		 }


	   
	    
}

	    
	  
	 


