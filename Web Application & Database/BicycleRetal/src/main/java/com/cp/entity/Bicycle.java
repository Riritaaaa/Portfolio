package com.cp.entity;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="bicycle")
public class Bicycle {
	@Id
	private String id;
	@JsonIgnore
	@ManyToOne(optional=true)
    @JoinColumn(name = "parking_id")
	private Parking parking;
	@JsonIgnore
	@OneToMany(targetEntity=Rental.class, mappedBy="bicycle",
    		cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rental> rental;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parkingSpace) {
		this.parking = parkingSpace;
	}
	public List<Rental> getRental() {
		return rental;
	}
	public void setRental(List<Rental> rental) {
		this.rental = rental;
	}
	

}
