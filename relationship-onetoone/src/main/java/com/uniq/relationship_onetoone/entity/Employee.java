package com.uniq.relationship_onetoone.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

    //owning side ,Parent Table

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int id;
    private String name;
    private String dept;

    @JsonManagedReference //avoid infinite loops
    @JoinColumn(name = "lap_id") // new column join panrom - fk
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Laptop laptop; //Association

    public Employee(){

    }

    public Employee(int id, String name, String dept, Laptop laptop) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.laptop = laptop;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
