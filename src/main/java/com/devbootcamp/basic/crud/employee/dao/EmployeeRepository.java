package com.devbootcamp.basic.crud.employee.dao;

import com.devbootcamp.basic.crud.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
