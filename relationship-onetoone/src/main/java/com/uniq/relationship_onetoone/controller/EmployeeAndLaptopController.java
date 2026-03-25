package com.uniq.relationship_onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniq.relationship_onetoone.entity.Employee;
import com.uniq.relationship_onetoone.service.EmployeeAndLaptopServiceInterface;

@RestController
@RequestMapping("/api")
public class EmployeeAndLaptopController {

    @Autowired
    private EmployeeAndLaptopServiceInterface service;

    //empid = 1 lapid = 3 -> mapping
    @PostMapping("/mapping")
    public Employee mapValue(@RequestParam int empId ,@RequestParam int lapId){
        return service.getMapping(empId,lapId);

    }
    @DeleteMapping("/deletemap")
    public String mapdeleteValue(@RequestParam int empId){
        return service.deleteMapping(empId);
    }
    @PutMapping("/updatemap")
    public Employee mapupdateValue(@RequestParam int empId,@RequestParam int lapId){
        return service.updateMapping(empId,lapId);
    }
    @GetMapping("/getallmap")
    public Employee mapgetValue(@RequestParam int empId){
        return service.getallMapping(empId);
    }
}
