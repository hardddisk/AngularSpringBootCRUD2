package com.az.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Getter @Setter private String empId;
    @Getter @Setter private String name;
    @Getter @Setter private String designation;
    @Getter @Setter private String salary;

}
