package com.Insurance.InsTest.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Insurance.InsTest.Exception.ResourceNotFoundException;
import com.Insurance.InsTest.Model.AccountType;
import com.Insurance.InsTest.Model.Bank;
import com.Insurance.InsTest.Model.Country;
import com.Insurance.InsTest.Model.DocumentType;
import com.Insurance.InsTest.Model.Master;
import com.Insurance.InsTest.Model.PlanType;
import com.Insurance.InsTest.Model.States;
import com.Insurance.InsTest.Repository.AccountTypeRepository;
import com.Insurance.InsTest.Repository.BankRepository;
import com.Insurance.InsTest.Repository.CountryRepository;
import com.Insurance.InsTest.Repository.DocumentTypeRepository;
import com.Insurance.InsTest.Repository.PlanTypeRepository;
import com.Insurance.InsTest.Repository.StatesRepository;
import com.Insurance.InsTest.Service.AccountTypeService;
import com.Insurance.InsTest.Service.BankService;
import com.Insurance.InsTest.Service.CountryService;
import com.Insurance.InsTest.Service.DocumentTypeService;
import com.Insurance.InsTest.Service.PlanTypeService;
import com.Insurance.InsTest.Service.StatesService;



@RestController
@RequestMapping("/common")    
public class CommonController {

	//objects

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	StatesService stateservice;

	@Autowired
	CountryService countryService;

	@Autowired
	DocumentTypeService documentTypeService;

	@Autowired
	AccountTypeService accountTypeService;

	@Autowired
	BankService bankService;

	@Autowired
	PlanTypeService typeService; 



	//logger object

	Logger logger= LoggerFactory.getLogger(CommonController.class);



	//methods to get all details of entity
		@GetMapping("/allcountry1")  //ALL
		public List<Country> getAllCountry()
		{	
			try
			{
				logger.info("[getAllCountry] to get all country list ");
				logger.debug("debug msg");
				logger.error("error msg");
				logger.trace("trace msg");
				
				long totalcount=countryRepository.count();
				return countryRepository.findAll();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				throw e;
			}
		}



	@GetMapping("/allstates1")  //ALL
	public List<States> getAllStates()
	{
		logger.info("[getAllStates] to get all States list ");
		return stateservice.findAllStates();
	}

	@GetMapping("/alldocument1")  //ALL
	public List<DocumentType> getAllDocument()
	{
		logger.info("[getAllDocument] to get all DocumentType list ");
		return documentTypeService.findAllDocumentType();
	}

	@GetMapping("/allaccountype1")  //ALL
	public List<AccountType> getAllAccountType()
	{
		logger.info("[getAllAccountType] to get all AccountType list ");
		return accountTypeService.getAllAccountType();
	}

	@GetMapping("/allbank1")  //ALL
	public List<Bank> getAllBank()
	{
		logger.info("[getAllBank] to get all Bank list ");
		return bankService.getAllBank();
	}	


	@GetMapping("/allplantype1")  //ALL
	public List<PlanType> getAllPlanType()
	{
		logger.info("[getAllPlanType] to get all PlanType list ");
		return typeService.getAllPlanType();
	}

	//------------------------------------------------------------------------------------------------------------------------


	@GetMapping("/allcountry")  //ALL
	public List<Country> getAllCountryPagination(@RequestParam int page, @RequestParam int size)
	{	
		logger.warn("may not display according to thwe given sixe and page values");
		Pageable pageable = PageRequest.of(page, size);
		List<Country> list =countryRepository.findAll(pageable).getContent();
		return list;

	}



	@Autowired
	StatesRepository staterepository;

	@GetMapping("/allstates")  //ALL
	public List<States> getAllStatesPagination(@RequestParam int page, @RequestParam int size)
	{	
		logger.warn("may not display according to thwe given sixe and page values");
		Pageable pageable = PageRequest.of(page, size);
		List<States> list =staterepository.findAll(pageable).getContent();
		return list;
	}


	@Autowired
	DocumentTypeRepository typeRepository;

	@GetMapping("/alldocument")  //ALL
	public List<DocumentType> getAllDocumentPagination(@RequestParam int page, @RequestParam int size)
	{	
		logger.warn("may not display according to thwe given sixe and page values");
		Pageable pageable = PageRequest.of(page, size);
		List<DocumentType> list =typeRepository.findAll(pageable).getContent();
		return list;
	}




	@Autowired
	AccountTypeRepository accountTypeRepository;
	@GetMapping("/allaccountype")  //ALL
	public List<AccountType> getAllAccountTypePagination(@RequestParam int page, @RequestParam int size)
	{	
		logger.warn("may not display according to thwe given sixe and page values");
		Pageable pageable = PageRequest.of(page, size);
		List<AccountType> list =accountTypeRepository.findAll(pageable).getContent();
		return list;
	}




	@Autowired
	BankRepository bankRepository;
	@GetMapping("/allbank")  //ALL
	public List<Bank> getAllBankPagination(@RequestParam int page, @RequestParam int size)
	{	
		logger.warn("may not display according to thwe given sixe and page values");
		Pageable pageable = PageRequest.of(page, size);
		List<Bank> list =bankRepository.findAll(pageable).getContent();
		return list;
	}



	@Autowired
	PlanTypeRepository planTypeRepository;
	@GetMapping("/allplantype")  //ALL
	public List<PlanType> getAllPlanTypePagination(@RequestParam int page, @RequestParam int size)
	{	
		logger.warn("may not display according to thwe given sixe and page values");
		Pageable pageable = PageRequest.of(page, size);
		List<PlanType> list =planTypeRepository.findAll(pageable).getContent();
		return list;
	}




	//-----------------------------------------------------------------------------------------------------------------------------




	//method to get alldetails of the present entities

	@GetMapping("/getmasterdata")
	public Master getAllEntity() throws ResourceNotFoundException
	{
		Master master=new Master();

		master.country=getAllCountry();

		master.state=getAllStates();

		master.documenttype=getAllDocument();

		master.accounttypes=getAllAccountType();

		master.bank=getAllBank();

		master.plantype=getAllPlanType();



		return master;

	}

	//method to get by id

	@GetMapping("/countryid/{id}")//byid
	public ResponseEntity<Country> getCountryById(@PathVariable(value="id") Long countryId )
			throws ResourceNotFoundException
	{
		logger.warn("id should be known");
		Country country = countryService.getCountryById(countryId)
				.orElseThrow(()-> new ResourceNotFoundException("Country not found for this id:: "+ countryId));

		return ResponseEntity.ok().body(country);
	}

	@GetMapping("/stateid/{id}")//byid
	public ResponseEntity<States> getStatesById(@PathVariable(value="id") Long StateId )
			throws ResourceNotFoundException
	{
		logger.warn("id should be known");
		States states = stateservice.getStatesBYId(StateId)
				.orElseThrow(()-> new ResourceNotFoundException("state not found for this id:: "+ StateId));

		return ResponseEntity.ok().body(states);
	}

	@GetMapping("/bankid/{id}")//byid
	public ResponseEntity<Bank> getBankById(@PathVariable(value="id") Long bankId )
			throws ResourceNotFoundException
	{
		logger.warn("id should be known");
		Bank bank = bankService.getBankById(bankId)
				.orElseThrow(()-> new ResourceNotFoundException("bank not found for this id:: "+ bankId));

		return ResponseEntity.ok().body(bank);
	}

	@GetMapping("/documenttypeid/{id}")//byid
	public ResponseEntity<DocumentType> getDocumentById(@PathVariable(value="id") Long DocumentTypeId )
			throws ResourceNotFoundException
	{
		logger.warn("id should be known");
		DocumentType documentType = documentTypeService.getDocumentTypeBYId(DocumentTypeId)
				.orElseThrow(()-> new ResourceNotFoundException("documenttype not found for this id:: "+ DocumentTypeId));

		return ResponseEntity.ok().body(documentType);
	}

	@GetMapping("/accounttypeid/{id}")//byid
	public ResponseEntity<AccountType> getAccountTypeById(@PathVariable(value="id") Long accountTypeId )
			throws ResourceNotFoundException
	{
		logger.warn("id should be known");
		AccountType accountType = accountTypeService.getAccountTypeById(accountTypeId)
				.orElseThrow(()-> new ResourceNotFoundException("accounttypeid not found for this id:: "+ accountTypeId));

		return ResponseEntity.ok().body(accountType);
	}
	@GetMapping("/plantype/{id}")//byid
	public ResponseEntity<PlanType> getPlanTypeById(@PathVariable(value="id") Long PlanTypeId )
			throws ResourceNotFoundException
	{
		logger.warn("id should be known");
		PlanType planType = typeService.getPlanTypeById(PlanTypeId)
				.orElseThrow(()-> new ResourceNotFoundException("accounttypeid not found for this id:: "+ PlanTypeId));

		return ResponseEntity.ok().body(planType);
	}
}

