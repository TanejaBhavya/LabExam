package com.traineeManagement.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trainee {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "trainee_id")
	private int id;
	   @Column(name = "trainee_name")
	private String name;
	    @Column(name = "branch")
	private String branch;
	    @Column(name = "percentage")
	private double percentage;
	
	public Trainee(int id, String name, String branch, double percentage){
		this.name = name;
		this.branch=branch;
		this.id=id;
		this.percentage=percentage;
	}
	
	public Trainee(String name, String branch, double percentage){
		this.name = name;
		this.branch=branch;
		this.percentage=percentage;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	
	@Override
	public String toString() {
		return "Trainee details : [id=" + id + ", name=" + name + ", branch=" + branch + ", percentage=" + percentage
				+ "]";
	}
	
}
