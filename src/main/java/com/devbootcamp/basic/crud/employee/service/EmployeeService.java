package com.devbootcamp.basic.crud.employee.service;

import com.devbootcamp.basic.crud.employee.dao.EmployeeRepository;
import com.devbootcamp.basic.crud.employee.entity.EmployeeEntity;
import com.devbootcamp.basic.crud.employee.exceptions.RecordNotFoundException;
import com.devbootcamp.basic.crud.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<EmployeeEntity> getAllEmployees()
    {
        List<EmployeeEntity> employeeList = repository.findAll();

        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }

    public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public EmployeeEntity createEmployee(Employee entity) throws RecordNotFoundException
    {
            EmployeeEntity newEntity = new EmployeeEntity();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity = repository.save(newEntity);
            return newEntity;
    }

    public EmployeeEntity updateEmployee(Employee entity) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> newEntity =repository.findById(entity.getId());
        if(newEntity.isPresent()){
            EmployeeEntity exitsingEntity=  newEntity.get();
            exitsingEntity .setEmail(entity.getEmail());
            exitsingEntity.setFirstName(entity.getFirstName());
            exitsingEntity.setLastName(entity.getLastName());
            return repository.save(exitsingEntity);
        }
        return null;
    }

}
