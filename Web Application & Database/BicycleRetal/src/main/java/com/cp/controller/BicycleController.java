package com.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.cp.entity.Bicycle;
import com.cp.entity.Parking;
import com.cp.service.BicycleService;
import com.cp.service.MemberService;
import com.cp.service.ParkingService;
import com.cp.service.RentalService;
import com.cp.use.AddBicycle;

@Controller
public class BicycleController {
	@Autowired
	private MemberService memService;
	@Autowired
	private BicycleService biService;
	@Autowired
	private RentalService renService;
	@Autowired
	private ParkingService parkService;
	
	@PostMapping("/add_bi")
	public String addBicycle(@Validated AddBicycle addBicycle, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:/bi_reg";
		}
		Parking parking = parkService.findParkById(addBicycle.getParking_id());
		for(int i=0; i<addBicycle.getAmount(); i++) {
			Bicycle bicycle = new Bicycle();
			bicycle.setId(biService.getNextId());
			bicycle.setParking(parking);
			biService.saveBicycle(bicycle);
		}
		return "redirect:/bi_list";
	}
}
