package com.UserManagement.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Laptop")
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int lapId;
	private String lapName;
	private String processor;
	
	 // Inverse side - child class
    @OneToOne(mappedBy = "laptop", fetch = FetchType.LAZY)
    @JsonBackReference
    private Students student;

	public Laptop() {
		super();
	}

	public int getLapId() {
		return lapId;
	}

	public void setLapId(int lapId) {
		this.lapId = lapId;
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

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}
    
    
}
