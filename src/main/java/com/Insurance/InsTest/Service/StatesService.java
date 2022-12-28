package com.Insurance.InsTest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Insurance.InsTest.Model.DocumentType;
import com.Insurance.InsTest.Model.States;
import com.Insurance.InsTest.Repository.StatesRepository;

@Service
public class StatesService {

	
	@Autowired
	StatesRepository statesRepository;
	
	public Optional<States>  getStatesBYId(Long id)
	{
		Optional<States> findById = statesRepository.findById(id);
		return findById;
	}

	public List<States> findAllStates()
	{
		return statesRepository.findAll();
	}
}
