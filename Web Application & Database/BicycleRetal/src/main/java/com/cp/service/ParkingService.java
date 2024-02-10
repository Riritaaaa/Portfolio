package com.cp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.entity.Parking;
import com.cp.repository.ParkingRepository;

@Service
public class ParkingService {
	@Autowired
	private ParkingRepository parkRepo;
	
	public List<Parking> findAllParking(){
		return (List<Parking>) parkRepo.findAll();
	}
	
	public Parking findParkById(String id) {
		return (Parking) parkRepo.findById(id).get();
	}
}
