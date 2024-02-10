package com.cp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cp.entity.Bicycle;
import com.cp.entity.Member;
import com.cp.entity.Parking;
import com.cp.entity.Rental;
import com.cp.service.BicycleService;
import com.cp.service.MemberService;
import com.cp.service.ParkingService;
import com.cp.service.RentalService;
import com.cp.use.AddRental;
import com.cp.use.AddReturn;

@Controller
public class RentalController {
	@Autowired
	private MemberService memService;
	@Autowired
	private BicycleService biService;
	@Autowired
	private RentalService renService;
	@Autowired
	private ParkingService parkService;
	
	@PostMapping("/add_ren")
	public String regRen(@Validated AddRental addRental, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:/ren_reg";
		}
		Rental rental = new Rental();
		Bicycle bicycle = biService.findBicycleById(addRental.getBicycle_id());
		rental.setId(renService.getNextId());
		rental.setBicycle(bicycle);
		rental.setMember(memService.findMemberById(addRental.getMember_id()));
		rental.setStartParking(bicycle.getParking());
		bicycle.setParking(null);
		rental.setStart_date(new Date());
		renService.saveRental(rental);
		biService.saveBicycle(bicycle);
		
		return "redirect:/ren_list";
	}
	
	@PostMapping("/return_bi/{id}")
	public String returnBi(@PathVariable("id") String id, @Validated AddReturn addReturn, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "redirect:/ren_return/"+id;
		}
		Rental rental = renService.findRentalById(id);
		Bicycle bicycle = rental.getBicycle();
		Parking parking = parkService.findParkById(addReturn.getParking_id());
		
		bicycle.setParking(parking);
		rental.setEndParking(parking);
		rental.setEnd_date(new Date());
		biService.saveBicycle(bicycle);
		renService.saveRental(rental);
		
		return "redirect:/return_list";
	}
}
