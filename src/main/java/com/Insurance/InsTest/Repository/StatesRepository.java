package com.Insurance.InsTest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Insurance.InsTest.Model.States;
@Repository
public interface StatesRepository  extends JpaRepository<States, Long> 
{

}
