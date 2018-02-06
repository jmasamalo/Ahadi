package com.appoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appoint.domain.Appointment;
import com.appoint.domain.Search;
import com.appoint.service.AppointmentService;



@RestController
@RequestMapping(value = "/ajax")
public class ApointController {
	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping
	public List<Appointment>  getAppointments( @RequestBody Search desc) {
		
		List<Appointment> appointments;
		if(desc==null || desc.getSearch().equals("")) {
			 appointments = appointmentService.getAll();
		}else {
			 appointments = appointmentService.findByDescription(desc.getSearch());
		}
		
		return appointments;
	}
	
	// This is useful for the purpose of viewing the json list from browser
	@GetMapping
	public List<Appointment>  getAllAppointments() {
		
		List<Appointment> appointments = appointmentService.getAll();
		
		return appointments;
	}
}
