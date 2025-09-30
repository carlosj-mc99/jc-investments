package org.com.jc.investments.repository;

import org.com.jc.investments.entitys.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStateRepository extends JpaRepository<State, Integer> {

}
