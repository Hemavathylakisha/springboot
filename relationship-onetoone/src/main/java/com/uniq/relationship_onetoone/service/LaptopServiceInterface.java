package com.uniq.relationship_onetoone.service;

import com.uniq.relationship_onetoone.entity.Employee;
import com.uniq.relationship_onetoone.entity.Laptop;

import java.util.List;

public interface LaptopServiceInterface {


    List<Laptop> getAllLaptops();

    Laptop getLaptop(int id);

    Laptop saveLaptop(String lapName,String processor);

    Laptop updateLaptop(int id,Laptop laptop);
}
