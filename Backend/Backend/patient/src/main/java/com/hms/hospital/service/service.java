package com.hms.hospital.service;

import com.hms.hospital.model.User;
import com.hms.hospital.model.patient;
import com.hms.hospital.repository.PatientRepository;
import com.hms.hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public patient updatePatient(patient patient) {

        Long id = patient.getId();
        patient std = patientRepository.findById(id).get();
        std.setAge(patient.getAge());
        std.setName(patient.getName());
        std.setBlood(patient.getBlood());
        std.setDose(patient.getDose());
        std.setFees(patient.getFees());
        std.setPrescription(patient.getPrescription());
        std.setUrgency(patient.getUrgency());
        std.setId(patient.getId());
        return patientRepository.save(std);

    }

	@Override
	public User login(String username, String password, String role) {
		return userRepository.findByUsernameAndPassword(username, password );
	}

    @Override
    public Object signup(User user) {
        return userRepository.save(user);
    }

}
