package com.Insurance.InsTest.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="states")
public class States {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long StateId;
	
	@Column(name="StateName")
	private String StateName;
	

	@Column(name="StateCode")
	private String StateCode;
	
	@Column(name="CountryId")
	private String CountryId;
	
	
	public long getStateId() {
		return StateId;
	}

	public void setStateId(long stateId) {
		StateId = stateId;
	}

	public String getStateName() {
		return StateName;
	}

	public void setStateName(String stateName) {
		StateName = stateName;
	}

	public String getStateCode() {
		return StateCode;
	}

	public void setStateCode(String stateCode) {
		StateCode = stateCode;
	}

	public String getCountryId() {
		return CountryId;
	}

	public void setCountryId(String countryId) {
		CountryId = countryId;
	}


	
}
