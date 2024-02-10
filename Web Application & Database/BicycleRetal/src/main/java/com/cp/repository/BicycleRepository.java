package com.cp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cp.entity.Bicycle;
import com.cp.entity.Parking;
import com.cp.entity.Rental;

public interface BicycleRepository extends CrudRepository<Bicycle, String>{
	List<Bicycle> findByParking(Parking parking);
	List<Bicycle> findByParkingIsNull();
	List<Bicycle> findByParkingNotNull();
}
