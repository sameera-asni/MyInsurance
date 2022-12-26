package com.Insurance.InsTest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Insurance.InsTest.Model.Bank;
import com.Insurance.InsTest.Repository.BankRepository;

@Service
public class BankService {
	@Autowired
	private BankRepository bankRepository;
		
	public Optional<Bank> getBankById(Long id)
	{
		Optional<Bank> findById = bankRepository.findById(id);
		return findById;
	}
	
	//get all
	public List<Bank> getAllBank()
	{
		return bankRepository.findAll();
	}
	
	

}
