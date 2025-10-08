package org.com.jc.investments.repository;

import org.com.jc.investments.entitys.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserTypeRepository extends JpaRepository<UserType, Integer> {

}
