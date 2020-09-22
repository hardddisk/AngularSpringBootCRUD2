package com.az.tutorial.service;


import com.az.tutorial.dto.EmployeeRepository;
import com.az.tutorial.exception.RecordNotFoundException;
import com.az.tutorial.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees()
    {
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();

        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Employee>();
        }
    }


    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }
    }


    public Employee createOrUpdateEmployee(Employee entity) {
        Optional<Employee> employee = employeeRepository.findById(entity.getId());

        if(employee.isPresent()) {

            Employee newEntity = employee.get();

            newEntity.setName(entity.getName());
            newEntity.setSalary(entity.getSalary());
            newEntity.setDesignation(entity.getDesignation());
            newEntity = employeeRepository.save(newEntity);

            return newEntity;

        } else {
            entity = employeeRepository.save(entity);

            return entity;
        }
    }


    public void deleteEmployeeById(Long id) throws RecordNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()) {
            employeeRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }


}
