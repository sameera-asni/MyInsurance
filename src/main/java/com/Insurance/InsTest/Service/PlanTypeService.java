package com.Insurance.InsTest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Insurance.InsTest.Model.AccountType;
import com.Insurance.InsTest.Model.PlanType;
import com.Insurance.InsTest.Repository.AccountTypeRepository;
import com.Insurance.InsTest.Repository.PlanTypeRepository;

@Service
public class PlanTypeService {

	@Autowired
	private PlanTypeRepository planTypeRepository;
		
	public Optional<PlanType> getPlanTypeById(Long id)
	{
		Optional<PlanType> findById = planTypeRepository.findById(id);
		return findById;
	}
	
	//get all
	public List<PlanType> getAllPlanType()
	{
		return planTypeRepository.findAll();
	}
}
