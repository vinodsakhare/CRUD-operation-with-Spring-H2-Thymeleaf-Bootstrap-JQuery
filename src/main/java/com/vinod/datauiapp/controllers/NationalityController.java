package com.vinod.datauiapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vinod.datauiapp.models.Nationality;
import com.vinod.datauiapp.services.NationalityService;

@Controller
public class NationalityController {

	@Autowired
	private NationalityService nationalityService;
	
	@GetMapping("/nationalities")
	public String getNationalities(Model model) {
		model.addAttribute("nationalities", nationalityService.getNationalities());
		return "nationalities";
	}	
	
	@GetMapping("/onenationality")
	@ResponseBody
	public Optional<Nationality> getNationalityById(Integer Id, Model model ) {
		model.addAttribute("onenationality", nationalityService.getNationalityById(Id));
		return nationalityService.getNationalityById(Id);
	}
	
	@RequestMapping(value="/save", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
	public String updateNationality(Nationality nationality) {
		nationalityService.updateNationality(nationality);
		return "redirect:/nationalities";
	}
	
	@RequestMapping(value="/addNew", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
	public String addNationality(Nationality nationality) {
		nationalityService.addNationality(nationality);
		return "redirect:/nationalities";
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
	public String deleteNationality(Integer Id) {
		nationalityService.deleteById(Id);
		return "redirect:/nationalities";
	}
}
