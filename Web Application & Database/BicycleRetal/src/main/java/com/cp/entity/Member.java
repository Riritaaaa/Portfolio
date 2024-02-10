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
@Table(name="member")
public class Member {
	@Id
	private String id;
	private String fname;
	private String lname;
	private String phone;
	private String email;
	private String address;
	private String gender;
	@JsonIgnore
	@OneToMany(targetEntity=Rental.class, mappedBy="member",
    		cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rental> rental;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<Rental> getRental() {
		return rental;
	}
	public void setRental(List<Rental> rental) {
		this.rental = rental;
	}
	
}
