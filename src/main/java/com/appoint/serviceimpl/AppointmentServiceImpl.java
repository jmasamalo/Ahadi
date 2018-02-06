package com.appoint.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appoint.domain.Appointment;
import com.appoint.repository.AppointmentRepository;
import com.appoint.service.AppointmentService;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	public List<Appointment> getAll() {
		return (List<Appointment>) appointmentRepository.findAll();
	}

	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	public Appointment get(Long id) {
		
		Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if(optionalAppointment.isPresent()) {
            return optionalAppointment.get();
        }
        return null;
	}

	// to be revisited

	@Override
	public Appointment findById(long id) {
		return appointmentRepository.findById(id);
	}

	@Override
	public List<Appointment> findByDescription(String desc) {
		return appointmentRepository.findBydescription(desc);
	};


}
