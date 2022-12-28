package com.Insurance.InsTest.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="accountType")
public class AccountType {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="AccountTypeId")
	private long accountTypeId;
	
	@Column(name="AccountType")
	private String accountType;

	public long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
