package com.uniq.relationship_onetoone.service;

import com.uniq.relationship_onetoone.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    List<Employee> getAllEmployees();

    Employee getEmployee(int id);

    Employee saveEmployee(String name,String dept);

    Employee updateEmployee(int id,Employee employee);
}
