package com.appoint.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appoint.domain.Appointment;
import com.appoint.service.AppointmentService;

@Controller
public class HomeController {
	@Autowired
	AppointmentService appointmentService;
	
	@RequestMapping(value={"/"}, method=RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("appointment", new Appointment()); 
		return "welcome";
	}

	@RequestMapping(value={"/"}, method=RequestMethod.POST)
	public String saveAppointment(@Valid @ModelAttribute("appointment") Appointment appointment, 
			BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "welcome";
		}
		
		appointmentService.save(appointment);

		return "redirect:/";
	}
}
