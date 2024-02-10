package com.cp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="parking")
public class Parking {
	@Id
	private String id;
	private String name;
	@JsonIgnore
	@OneToMany(targetEntity=Rental.class, mappedBy="startParking",
    		cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rental> startRental;
	@JsonIgnore
	@OneToMany(targetEntity=Rental.class, mappedBy="endParking",
    		cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rental> endRental;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Rental> getStartRental() {
		return startRental;
	}
	public void setStartRental(List<Rental> startRental) {
		this.startRental = startRental;
	}
	public List<Rental> getEndRental() {
		return endRental;
	}
	public void setEndRental(List<Rental> endRental) {
		this.endRental = endRental;
	}
	
	
	
	
}
