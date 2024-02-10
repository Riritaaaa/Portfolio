package com.cp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.entity.Member;
import com.cp.entity.Rental;
import com.cp.repository.RentalRepository;

@Service
public class RentalService {
	@Autowired
	private RentalRepository renRepo;
	
	public List<Rental> findAllRental(){
		return (List<Rental>) renRepo.findAll();
	}

	public List<Rental> findNoReturn(){
		return (List<Rental>) renRepo.findByEndParkingIsNull();
	}
	public List<Rental> findReturn(){
		return (List<Rental>) renRepo.findByEndParkingNotNull();
	}
	public Rental findRentalById(String renId) {
		return (Rental) renRepo.findById(renId).get();
	}
	
	public void saveRental(Rental ren) {
		renRepo.save(ren);
	}
	
	public void deleteRental(String renId) {
		Rental mem = renRepo.findById(renId).get();
		renRepo.delete(mem);
	}
	public String getNextId() {
		String nextId;
		List<Rental> renList = this.findAllRental();
		if (renList.size() > 0) {
			String lId = renList.get(renList.size() - 1).getId();
			int lastId = Integer.parseInt(lId.substring(1));
			nextId = String.format("R%03d", lastId + 1);
		} else {
			nextId = "R001";
		}
		return nextId;
	}

}
