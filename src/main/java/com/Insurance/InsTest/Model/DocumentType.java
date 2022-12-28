package com.Insurance.InsTest.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="documentType")
public class DocumentType 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long DocumentTypeId;
	
	
	@Column(name="DocumentType")
	private String DocumentType;


	public long getDocumentTypeId() {
		return DocumentTypeId;
	}


	public void setDocumentTypeId(long documentTypeId) {
		DocumentTypeId = documentTypeId;
	}


	public String getDocumentType() {
		return DocumentType;
	}


	public void setDocumentType(String documentType) {
		DocumentType = documentType;
	}
	
	

}
