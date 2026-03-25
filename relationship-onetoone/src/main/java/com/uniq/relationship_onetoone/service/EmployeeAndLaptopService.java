package com.uniq.relationship_onetoone.service;

import com.uniq.relationship_onetoone.entity.Employee;
import com.uniq.relationship_onetoone.entity.Laptop;
import com.uniq.relationship_onetoone.repository.EmployeeRepository;
import com.uniq.relationship_onetoone.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAndLaptopService implements EmployeeAndLaptopServiceInterface{


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LaptopRepository laptopRepository;

    //save the data
    @Override
    public Employee getMapping(int empId,int lapId) {

      Employee emp =  employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("The given id is not present"));

      Laptop lap =  laptopRepository.findById(lapId).orElseThrow(() -> new RuntimeException("The given id is not present"));

       //bi direction
       //setter
       emp.setLaptop(lap);
       lap.setEmployee(emp);

       //db save
        employeeRepository.save(emp);
        //laptopRepository.save(lap);

        return emp;

    }
    //delete
	@Override
	public String deleteMapping(int empId) {
		Employee emp=employeeRepository.findById(empId).orElseThrow(()->new RuntimeException("Emp id not found"+ empId));
		
		employeeRepository.delete(emp);
		return "Deleted emp data associated with lap_id";
	}

	//update
	@Override
	public Employee updateMapping(int empId, int lapId) {
		Employee emp=employeeRepository.findById(empId).orElseThrow(()->new RuntimeException("Emp id not found"+ empId));
		Laptop lap=laptopRepository.findById(lapId).orElseThrow(()->new RuntimeException("Lap id not found"+ empId));
	
	//setter
		emp.setLaptop(lap);
		
		//save updated
		employeeRepository.save(emp);
		return emp;
	}
	@Override
	public Employee getallMapping(int empId) {
		Employee emp=employeeRepository.findById(empId).orElseThrow(()->new RuntimeException("Emp id not found"+ empId));
		return emp;
	}
}
