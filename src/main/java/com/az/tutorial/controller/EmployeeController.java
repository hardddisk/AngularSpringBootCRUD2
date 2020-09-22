package com.az.tutorial.controller;


import com.az.tutorial.exception.RecordNotFoundException;
import com.az.tutorial.model.Employee;
import com.az.tutorial.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = employeeService.getAllEmployees();

        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }



    @PostMapping
    public  ResponseEntity<Employee> createOrUpdate(@RequestBody Employee entity) {

        Employee updatedOrInserted = employeeService.createOrUpdateEmployee(entity);

        return new ResponseEntity<Employee>(updatedOrInserted, new HttpHeaders(), HttpStatus.OK);

    }



    @DeleteMapping(path = { "/{id}" })
    public HttpStatus delete(@PathVariable("id") Long id) throws RecordNotFoundException {

        employeeService.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;

    }

}
