package com.hms.hospital.service;

import com.hms.hospital.model.doctor;
import com.hms.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class service {

	@Autowired
	private DoctorRepository doctorRepository;

	public doctor updateDoctor(doctor doctor) {

		Long id = doctor.getId();
		doctor std = doctorRepository.findById(id).get();
		std.setAge(doctor.getAge());
		std.setName(doctor.getName());
		std.setDegree(doctor.getDegree());
		std.setExperiance(doctor.getExperiance());
		std.setPrescription(doctor.getPrescription());
		std.setId(doctor.getId());
		return doctorRepository.save(std);

	}

}
