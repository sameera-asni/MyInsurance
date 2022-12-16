package com.Insurance.InsTest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Insurance.InsTest.Exception.ResourceNotFoundException;
import com.Insurance.InsTest.Model.Country;
import com.Insurance.InsTest.Repository.CountryRepository;
import com.Insurance.InsTest.Service.CountryService;

@RestController
@RequestMapping("/api")
public class CountryController {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CountryService countryService;

	@GetMapping("/countries")
	public List<Country> getAllCountry()
	{
		return this.countryRepository.findAll();
	}

	@GetMapping("/countries/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable(value="id") Long countryId )
			throws ResourceNotFoundException
	{
		Country country = countryService.getCountryById(countryId)
				.orElseThrow(()-> new ResourceNotFoundException("Country not found for this id:: "+ countryId));

		return ResponseEntity.ok().body(country);
	}

}

