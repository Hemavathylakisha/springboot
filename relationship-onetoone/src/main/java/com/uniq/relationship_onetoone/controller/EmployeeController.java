package com.uniq.relationship_onetoone.controller;

import com.uniq.relationship_onetoone.entity.Employee;
import com.uniq.relationship_onetoone.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceInterface service;

    //1.get all employees
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return service.getAllEmployees();
    }

    //2. get a single employee
    @GetMapping("/employee/{id}")
    public Employee getSingleEmp(@PathVariable int id){
        return service.getEmployee(id);
    }

    //3. save a employee

    @PostMapping("/saveemp")
    public Employee saveEmp(@RequestParam String name,@RequestParam String dept){
        return service.saveEmployee(name,dept);

    }

    //4. update a value

    @PutMapping("/update/{id}")
    public Employee updateEmp(@PathVariable int id,@RequestBody Employee employee){

        return service.updateEmployee(id,employee);

    }




}
