package org.com.jc.investments.service;

import org.com.jc.investments.dtos.CompanyDto;
import org.com.jc.investments.entitys.Company;

public interface ICompanyService {
	
	public Company create(CompanyDto dto);

}