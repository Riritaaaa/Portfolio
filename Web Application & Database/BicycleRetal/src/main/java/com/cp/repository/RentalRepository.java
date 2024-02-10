package com.cp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cp.entity.Parking;
import com.cp.entity.Rental;

public interface RentalRepository extends CrudRepository<Rental, String>{
	List<Rental> findByEndParkingIsNull();
	List<Rental> findByEndParkingNotNull();
	
}
