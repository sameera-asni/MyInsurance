package com.Insurance.InsTest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Insurance.InsTest.Model.AccountType;
import com.Insurance.InsTest.Repository.AccountTypeRepository;

@Service
public class AccountTypeService {

	@Autowired
	private AccountTypeRepository accountTypeRepository;
		
	public Optional<AccountType> getAccountTypeById(Long id)
	{
		Optional<AccountType> findById = accountTypeRepository.findById(id);
		return findById;
	}
	
	//get all
	public List<AccountType> getAllAccountType()
	{
		return accountTypeRepository.findAll();
	}
	
}
