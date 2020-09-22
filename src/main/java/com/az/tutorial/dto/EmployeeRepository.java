package com.az.tutorial.dto;

import com.az.tutorial.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByName(String name);

    Optional<Employee> findById(Long id);




}
