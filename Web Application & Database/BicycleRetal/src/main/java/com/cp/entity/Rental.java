package com.cp.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="rental")
public class Rental {
	@Id
	private String id;
	private Date start_date;
	private Date end_date;
	@JsonIgnore 
	@ManyToOne(optional=true)
	@JoinColumn(name="member_id")
	private Member member;
	@JsonIgnore 
	@ManyToOne(optional=true)
	@JoinColumn(name="bicycle_id")
	private Bicycle bicycle;
	@JsonIgnore 
	@ManyToOne(optional=true)
	@JoinColumn(name="start_statn")
	private Parking startParking;
	@JsonIgnore 
	@ManyToOne(optional=true)
	@JoinColumn(name="end_statn")
	private Parking endParking;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Bicycle getBicycle() {
		return bicycle;
	}
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
	public Parking getStartParking() {
		return startParking;
	}
	public void setStartParking(Parking startParking) {
		this.startParking = startParking;
	}
	public Parking getEndParking() {
		return endParking;
	}
	public void setEndParking(Parking endParking) {
		this.endParking = endParking;
	}
	
}
