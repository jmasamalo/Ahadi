package com.appoint.service;

import java.util.List;

import com.appoint.domain.Appointment;

public interface AppointmentService {

	public List<Appointment> getAll();

	public Appointment save(Appointment appointment);

	public Appointment get(Long id);
	
	// To be revisited
	
	public Appointment findById(long id);
	
	public List<Appointment> findByDescription(String desc);
	
}
