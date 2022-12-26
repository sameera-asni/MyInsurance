package com.Insurance.InsTest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Insurance.InsTest.Exception.ResourceNotFoundException;
import com.Insurance.InsTest.Model.DocumentType;
import com.Insurance.InsTest.Model.States;
import com.Insurance.InsTest.Service.StatesService;

@RestController
@RequestMapping("/states")
public class StatesController {

	@Autowired
	StatesService service;
	

	@GetMapping("/all")  //ALL
	public List<States> getAllCountry()
	{
		return service.findAllStates();
	}
	
	
	@GetMapping("/byid/{id}")//byid
	public ResponseEntity<States> getCountryById(@PathVariable(value="id") long StateId )
			throws ResourceNotFoundException
	{
		States states = service.getStatesBYId(StateId)
				.orElseThrow(()-> new ResourceNotFoundException("DocumentType not found for this id:: "+ StateId));

		return ResponseEntity.ok().body(states);
	}
	
	
}
