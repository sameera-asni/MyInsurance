package com.Insurance.InsTest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Insurance.InsTest.Exception.ResourceNotFoundException;

import com.Insurance.InsTest.Model.DocumentType;
import com.Insurance.InsTest.Service.DocumentTypeService;

@RestController
@RequestMapping("/documenttype")
public class DocumentTypeController 
{
	@Autowired
	DocumentTypeService documentTypeService;
	
	@GetMapping("/all")  //ALL
	public List<DocumentType> getAllCountry()
	{
		return documentTypeService.findAllDocumentType();
	}
	
	
	@GetMapping("/byid/{id}")//byid
	public ResponseEntity<DocumentType> getCountryById(@PathVariable(value="id") Long DocumentTypeId )
			throws ResourceNotFoundException
	{
		DocumentType documentType = documentTypeService.getDocumentTypeBYId(DocumentTypeId)
				.orElseThrow(()-> new ResourceNotFoundException("DocumentType not found for this id:: "+ DocumentTypeId));

		return ResponseEntity.ok().body(documentType);
	}
	
}
