package com.hms.hospital.service;

import com.hms.hospital.model.User;
import com.hms.hospital.model.patient;

public interface PatientService {

     patient updatePatient(patient patient);

     User login(String username, String password, String role);

     Object signup(User user);

}

