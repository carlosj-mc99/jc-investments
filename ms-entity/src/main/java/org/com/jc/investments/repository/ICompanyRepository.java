package org.com.jc.investments.repository;

import org.com.jc.investments.entitys.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Integer> {

}
