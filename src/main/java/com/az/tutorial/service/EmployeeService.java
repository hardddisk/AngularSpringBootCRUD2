package com.az.tutorial.service;


import com.az.tutorial.dto.EmployeeRepository;
import com.az.tutorial.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public Employee getEmployeeById(Long id)
    {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }
    }


    public Employee createOrUpdateEmployee(Employee entity)
    {
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


}
