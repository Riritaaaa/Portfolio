package com.cp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.cp.entity.Member;
import com.cp.service.BicycleService;
import com.cp.service.MemberService;
import com.cp.service.ParkingService;
import com.cp.service.RentalService;
import com.cp.use.AddBicycle;

@Controller
public class MemberController {
	@Autowired
	private MemberService memService;
	@Autowired
	private BicycleService biService;
	@Autowired
	private RentalService renService;
	@Autowired
	private ParkingService parkService;
	
	@PostMapping("/mem_reg")
	public String regMember(@Validated Member member, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:/mem_reg";
		}
		
		member.setId(memService.getNextId());
		memService.saveMember(member);
		return "redirect:/";
	}
}
