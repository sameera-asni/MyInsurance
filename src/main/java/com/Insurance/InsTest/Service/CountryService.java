package com.Insurance.InsTest.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Insurance.InsTest.Model.Country;
import com.Insurance.InsTest.Repository.CountryRepository;

@Service
public class CountryService 
{
	@Autowired
	private CountryRepository countryRepository;
	
	public Optional<Country> getCountryById(Long id)
	{
		Optional<Country> findById = countryRepository.findById(id);
		return findById;
	}

}
