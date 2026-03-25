package com.uniq.relationship_onetoone.controller;

import com.uniq.relationship_onetoone.entity.Employee;
import com.uniq.relationship_onetoone.entity.Laptop;
import com.uniq.relationship_onetoone.service.EmployeeServiceInterface;
import com.uniq.relationship_onetoone.service.LaptopServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LaptopController {


    @Autowired
    private LaptopServiceInterface service;

    //1.get all laptops
    @GetMapping("/laptops")
    public List<Laptop> getLaptops(){
        return service.getAllLaptops();
    }

    //2. get a single laptop
    @GetMapping("/laptop/{id}")
    public Laptop getSingleLaptop(@PathVariable int id){
        return service.getLaptop(id);
    }

    //3. save a laptop

    //@ResponseBody - 500 internal server error
    @PostMapping("/savelap")
    public Laptop saveLap(@RequestParam String lapName, @RequestParam String processor){
        return service.saveLaptop(lapName, processor);

    }

    //4. update a value

    @PutMapping("/updatelap/{id}")
    public Laptop updateLap(@PathVariable int id,@RequestBody Laptop laptop){

        return service.updateLaptop(id, laptop);

    }

}
