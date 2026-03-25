package com.uniq.relationship_onetoone.service;

import com.uniq.relationship_onetoone.entity.Employee;
import com.uniq.relationship_onetoone.entity.Laptop;
import com.uniq.relationship_onetoone.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService  implements  LaptopServiceInterface{

    @Autowired
    private LaptopRepository repository;

    @Override
    public List<Laptop> getAllLaptops() {
        return repository.findAll();
    }

    @Override
    public Laptop getLaptop(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("The given id is not present"));
    }

    @Override
    public Laptop saveLaptop(String lapName, String processor) {
        Laptop laptop = new Laptop();
        laptop.setLapName(lapName);
        laptop.setProcessor(processor);
        return repository.save(laptop);

    }

    @Override
    public Laptop updateLaptop(int id, Laptop laptop) {
        Laptop existing = repository.findById(id).orElseThrow(() -> new RuntimeException("The given id is not present"));
        existing.setLapName(laptop.getLapName());
        existing.setProcessor(laptop.getProcessor());
        return repository.save(existing);
    }
}
