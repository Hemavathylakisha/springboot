package com.uniq.relationship_onetoone.service;

import com.uniq.relationship_onetoone.entity.Employee;
import com.uniq.relationship_onetoone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements  EmployeeServiceInterface
{
    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("The given id is not present"));
    }

    @Override
    public Employee saveEmployee(String name, String dept) {
        //parameter value - entity
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDept(dept);
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee existing = repository.findById(id).orElseThrow(() -> new RuntimeException("The given id is not present"));
        existing.setDept(employee.getDept());
        existing.setName(employee.getName());

        return repository.save(existing);
    }
}
