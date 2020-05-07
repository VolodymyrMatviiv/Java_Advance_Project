package ua.lviv.lgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.service.EntrantService;

@Controller
public class EntrantController {
	
	@Autowired
	EntrantService entrantService;
	
	@RequestMapping(value = "/addEntrant", method = RequestMethod.POST)
	public ModelAndView createEntrant(@Valid @ModelAttribute("entrant") Entrant entrant,
			BindingResult bindingResult) {
		
		entrantService.save(entrant);
		ModelAndView map = new ModelAndView("home");
		map.addObject("entrant", entrantService.getAllEntrants());
		return map;
	}

}
