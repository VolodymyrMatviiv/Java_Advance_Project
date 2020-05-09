package ua.lviv.lgs.controller;

import java.io.IOException;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.dao.FacultyRepository;
//import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.service.EntrantDTOHelper;
import ua.lviv.lgs.service.EntrantService;

@Controller
public class EntrantController {
	
	@Autowired
	EntrantService entrantService;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@RequestMapping(value = "/addEntrant", method = RequestMethod.POST)
	public ModelAndView createEntrant(
			@RequestParam MultipartFile image, 
			@RequestParam String firstName, 
			@RequestParam String lastName,
			@RequestParam Integer faculty,
			@RequestParam Integer firstSubject,
			@RequestParam Integer secondSubject,
			@RequestParam Integer thirdSubject,
			@RequestParam Integer fourthSubject) throws IOException {
		
		System.out.println(faculty);
		
		entrantService.save(EntrantDTOHelper.createEntity(image, firstName, lastName, facultyRepository.getById(faculty), null, firstSubject, secondSubject, thirdSubject, fourthSubject));
		
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value = "/success-entrans", method = RequestMethod.GET)
	public ModelAndView sucessEntrans() throws IOException {		
		ModelAndView map = new ModelAndView("successEntrant");

		map.addObject("entrants", entrantService.sortedEntrants());
		
    	return map;

	}

}
