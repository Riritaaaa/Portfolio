package com.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cp.entity.Bicycle;
import com.cp.entity.Member;
import com.cp.entity.Parking;
import com.cp.entity.Rental;
import com.cp.service.BicycleService;
import com.cp.service.MemberService;
import com.cp.service.ParkingService;
import com.cp.service.RentalService;
import com.cp.use.AddBicycle;
import com.cp.use.AddRental;
import com.cp.use.AddReturn;


@Controller
public class MainController {
	@Autowired
	private MemberService memService;
	@Autowired
	private BicycleService biService;
	@Autowired
	private RentalService renService;
	@Autowired
	private ParkingService parkService;
	
	@GetMapping("/")
	public String homeMenu(Model model) {
		return "home";
	}
	@GetMapping("/bi_edit")
	public String biEditMenu(Model model) {
		return "bicycleEdit";
	}
	@GetMapping("/bi_list")
	public String biListMenu(Model model) {
		List<Bicycle> biList = biService.findAllBicycle();
		List<Parking> parkList = parkService.findAllParking();
		model.addAttribute("biList", biList);
		model.addAttribute("parkList", parkList);
		return "bicycleList";
	}
	@GetMapping("/bi_reg")
	public String biRegMenu(Model model) {
		AddBicycle ab = new AddBicycle();
		List<Parking> parkingList = parkService.findAllParking();
		model.addAttribute("bicycle", ab);
		model.addAttribute("parkingList", parkingList);
		return "bicycleRegister";
	}
	@GetMapping("/mem_reg")
	public String memRegMenu(Model model) {
		Member member = new Member();
		model.addAttribute("member", member);
		return "memberRegister";
	}
	@GetMapping("/ren_list")
	public String renListMenu(Model model) {
		List<Rental> renList = renService.findNoReturn();
		List<Bicycle> biList = biService.findAllBicycle();
		List<Parking> parkList = parkService.findAllParking();
		List<Member> memList = memService.findAllMember();
		model.addAttribute("renList", renList);
		model.addAttribute("memList", memList);
		model.addAttribute("biList", biList);
		model.addAttribute("parkList", parkList);
		return "rentalList";
	}
	@GetMapping("/ren_reg")
	public String renBiMenu(Model model) {
		AddRental addRental = new AddRental();
		List<Bicycle> biList = biService.findAllAvailable();
		List<Parking> parkList = parkService.findAllParking();
		List<Member> memList = memService.findAllMember();
		model.addAttribute("addRental", addRental);
		model.addAttribute("biList", biList);
		model.addAttribute("parkList", parkList);
		model.addAttribute("memList", memList);
		return "rentalBicycle";
	}
	@GetMapping("/ren_return/{id}")
	public String biReturnMenu(@PathVariable("id") String id, Model model) {
		AddReturn addReturn = new AddReturn();
		addReturn.setRental_id(id);
		List<Parking> parkingList = parkService.findAllParking();
		model.addAttribute("addReturn", addReturn);
		model.addAttribute("parkingList", parkingList);
		return "returnReg";
	}
	@GetMapping("/return_list")
	public String returnListMenu(Model model) {
		List<Rental> renList = renService.findReturn();
		List<Bicycle> biList = biService.findAllBicycle();
		List<Parking> parkList = parkService.findAllParking();
		List<Member> memList = memService.findAllMember();
		model.addAttribute("renList", renList);
		model.addAttribute("memList", memList);
		model.addAttribute("biList", biList);
		model.addAttribute("parkList", parkList);
		return "returnList";
	}
	
}
