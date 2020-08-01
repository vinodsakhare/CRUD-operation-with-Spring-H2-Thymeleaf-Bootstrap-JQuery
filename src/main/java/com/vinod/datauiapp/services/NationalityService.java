package com.vinod.datauiapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinod.datauiapp.models.Nationality;
import com.vinod.datauiapp.repositories.NationalityRepository;

@Service
public class NationalityService {

	@Autowired
	private NationalityRepository nationalityRepository;
	
	public List<Nationality> getNationalities(){
		return nationalityRepository.findAll();
	}
	
	public Optional<Nationality> getNationalityById(Integer Id) {
		return nationalityRepository.findById(Id);
	}
	
	public void addNationality(Nationality nationality) {
		nationalityRepository.save(nationality);
	}
	
	public void updateNationality(Nationality nationality) {
		nationalityRepository.save(nationality);
	}
	
	public void deleteById(Integer Id) {
		nationalityRepository.deleteById(Id);
	}
}
