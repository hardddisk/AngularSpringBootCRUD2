package com.az.tutorial.controller;


import com.az.tutorial.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {


    private List<Employee>  employees = createList();


    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public List<Employee> getEmployees(){
        return employees;
    }


    @PostMapping
    public Employee create(@RequestBody Employee user) {
        employees.add(user);
        return user;
    }


    private static List<Employee> createList(){
        List<Employee> tempEmployee = new ArrayList<>();

        /*

        Employee employee1 = new Employee("1", "Azad", "java Programmer", "300,000");
        Employee employee2 = new Employee("2", "Enrico", "python Programmer", "400,000");
        Employee employee3 = new Employee("3", "Patrick", "C++ Programmer", "500,000");
        Employee employee4 = new Employee("4", "Mathew", "Angular Programmer", "600,000");
        Employee employee5 = new Employee("5", "Sourabh", "Cobol Programmer", "700,000");

        tempEmployee.add(employee1);
        tempEmployee.add(employee2);
        tempEmployee.add(employee3);
        tempEmployee.add(employee4);
        tempEmployee.add(employee5);
*/
        return tempEmployee;
    }

}
