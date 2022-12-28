package com.Insurance.InsTest.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="planType")
public class PlanType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long PlanTypeId;
	
	@Column(name = "InsuranceTypeId")
	private long InsuranceTypeId;
	
	@Column(name = "PlanTypeCode")
	private String PlanTypeCode;
	
	
	@Column(name = "PlanTypeName")
	private String PlanTypeName;


	public long getPlanTypeId() {
		return PlanTypeId;
	}


	public void setPlanTypeId(long planTypeId) {
		PlanTypeId = planTypeId;
	}


	public long getInsuranceTypeId() {
		return InsuranceTypeId;
	}


	public void setInsuranceTypeId(long insuranceTypeId) {
		InsuranceTypeId = insuranceTypeId;
	}


	public String getPlanTypeCode() {
		return PlanTypeCode;
	}


	public void setPlanTypeCode(String planTypeCode) {
		PlanTypeCode = planTypeCode;
	}


	public String getPlanTypeName() {
		return PlanTypeName;
	}


	public void setPlanTypeName(String planTypeName) {
		PlanTypeName = planTypeName;
	}
	
	
	
}
