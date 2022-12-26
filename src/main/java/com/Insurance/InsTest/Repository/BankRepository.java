package com.Insurance.InsTest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Insurance.InsTest.Model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{

}
