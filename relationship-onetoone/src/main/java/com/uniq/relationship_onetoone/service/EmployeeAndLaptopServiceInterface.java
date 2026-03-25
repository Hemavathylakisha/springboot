package com.uniq.relationship_onetoone.service;

import com.uniq.relationship_onetoone.entity.Employee;
import com.uniq.relationship_onetoone.entity.Laptop;

public interface EmployeeAndLaptopServiceInterface {

	//save
    Employee getMapping(int empId, int lapId);
    
    //delete
    String deleteMapping(int empId);
    
    //update
    Employee updateMapping(int empId,int lapId);
    
    //getbyID
    Employee getallMapping(int empId);
}
