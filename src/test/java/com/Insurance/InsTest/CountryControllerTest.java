package com.Insurance.InsTest;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.Insurance.InsTest.Controller.CountryController;
import com.Insurance.InsTest.Model.Country;
import com.Insurance.InsTest.Repository.CountryRepository;
import com.Insurance.InsTest.Service.CountryService;
import org.junit.Assert;
import org.junit.Before;

@SpringBootTest
public class CountryControllerTest 
{
	@Autowired
	private CountryController countryController;
	
	@MockBean
	private  CountryService countryService;

    @Before
    public void setup()
    {
    	MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testGetCountryById() throws Exception
	{
		CountryRepository countryRepository = Mockito.mock(CountryRepository.class);
		Country countries_1= new Country();
		countries_1.setCountryId(1);
		countries_1.setCountryCode("IND");
		countries_1.setCountryName("India");
		
		long id=1;
		Mockito.when(countryService.getCountryById(Mockito.any())).thenReturn(Optional.of(countries_1));
		ResponseEntity<Country> countryById = countryController.getCountryById(id);
		
		Assert.assertEquals(HttpStatus.OK.value(),countryById.getStatusCodeValue());
		
	}

}
