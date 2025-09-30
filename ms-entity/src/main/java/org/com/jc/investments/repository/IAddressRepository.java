package org.com.jc.investments.repository;

import org.com.jc.investments.entitys.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Integer> {

}
