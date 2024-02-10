package com.cp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.entity.Bicycle;
import com.cp.entity.Parking;
import com.cp.repository.BicycleRepository;

@Service
public class BicycleService {
	@Autowired
	private BicycleRepository biRepo;

	public boolean isExistByBicycleId(String biId) {
		Optional bi = biRepo.findById(biId);
		return bi.isEmpty();
	}

	public List<Bicycle> findAllBicycle() {
		return (List<Bicycle>) biRepo.findAll();
	}

	public List<Bicycle> findAllByParking(Parking parking) {
		return (List<Bicycle>) biRepo.findByParking(parking);
	}
	public List<Bicycle> findAllAvailable(){
		return (List<Bicycle>) biRepo.findByParkingNotNull();
	}

	public Bicycle findBicycleById(String biId) {
		return (Bicycle) biRepo.findById(biId).get();
	}

	public void saveBicycle(Bicycle bi) {
		biRepo.save(bi);
	}

	public void deleteBicycle(String biId) {
		Bicycle bi = biRepo.findById(biId).get();
		biRepo.delete(bi);
	}

	public String getNextId() {
		String nextId;
		List<Bicycle> biList = this.findAllBicycle();
		if (biList.size() > 0) {
			String lId = biList.get(biList.size() - 1).getId();
			int lastId = Integer.parseInt(lId.substring(1));
			nextId = String.format("B%03d", lastId + 1);
		} else {
			System.out.println("New");
			nextId = "B001";
		}
		return nextId;
	}
}
