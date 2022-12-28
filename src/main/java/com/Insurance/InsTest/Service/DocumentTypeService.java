package com.Insurance.InsTest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Insurance.InsTest.Model.Country;
import com.Insurance.InsTest.Model.DocumentType;
import com.Insurance.InsTest.Repository.DocumentTypeRepository;


@Service
public class DocumentTypeService 
{
	@Autowired
	DocumentTypeRepository documentTypeRepository;

	public Optional<DocumentType>  getDocumentTypeBYId(Long id)
	{
		Optional<DocumentType> findById = documentTypeRepository.findById(id);
		return findById;
	}

	public List<DocumentType> findAllDocumentType()
	{
		return documentTypeRepository.findAll();
	}
}