package com.uniq.relationship_onetoone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lapName;
    private String processor;


    @JsonBackReference//avoid infinite loop
    @OneToOne(mappedBy = "laptop")
    private Employee employee;

    public Laptop(){

    }

    public Laptop(int id, String lapName, String processor, Employee employee) {
        this.id = id;
        this.lapName = lapName;
        this.processor = processor;
        this.employee = employee;
    }


    public int getId() {
        return id;
    }

    public String getLapName() {
        return lapName;
    }

    public void setLapName(String lapName) {
        this.lapName = lapName;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
