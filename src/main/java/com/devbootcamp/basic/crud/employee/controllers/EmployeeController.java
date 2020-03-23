package com.devbootcamp.basic.crud.employee.controllers;

import com.devbootcamp.basic.crud.employee.entity.EmployeeEntity;
import com.devbootcamp.basic.crud.employee.exceptions.RecordNotFoundException;
import com.devbootcamp.basic.crud.employee.model.Employee;
import com.devbootcamp.basic.crud.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();

        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        EmployeeEntity entity = service.getEmployeeById(id);

        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> createEmployee(Employee employee)
            throws RecordNotFoundException {
        EmployeeEntity updated = service.createEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/update-employee")
    public ResponseEntity<EmployeeEntity> updateEmployee(Employee employee)
            throws RecordNotFoundException {
        EmployeeEntity updated = service.updateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
}
