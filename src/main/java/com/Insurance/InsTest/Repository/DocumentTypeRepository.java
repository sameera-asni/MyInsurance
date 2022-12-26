package com.Insurance.InsTest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Insurance.InsTest.Model.DocumentType;
@Repository
public interface DocumentTypeRepository  extends JpaRepository<DocumentType, Long	> 
{

}
