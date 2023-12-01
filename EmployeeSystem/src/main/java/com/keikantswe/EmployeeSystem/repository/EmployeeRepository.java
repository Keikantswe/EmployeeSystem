package com.keikantswe.EmployeeSystem.repository;

import com.keikantswe.EmployeeSystem.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {


}
