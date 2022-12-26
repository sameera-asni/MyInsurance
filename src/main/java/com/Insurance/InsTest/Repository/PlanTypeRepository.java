package com.Insurance.InsTest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Insurance.InsTest.Model.PlanType;
@Repository
public interface PlanTypeRepository extends JpaRepository<PlanType, Long> 
{

}
