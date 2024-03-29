package com.hms.hospital.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import com.hms.hospital.model.doctor;
import com.hms.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("/api/v4/")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/doctors")


    public List<doctor> getAllDoctors(){



        return doctorRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/patients")
    public doctor createDoctor(@RequestBody doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<doctor> getDoctorById(@PathVariable Long id) throws AttributeNotFoundException {

        doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("ABCD" + id));

        return ResponseEntity.ok(doctor);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<doctor> updateDoctor(@PathVariable Long id, @RequestBody doctor doctorDetails) throws AttributeNotFoundException{

        doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("ABCD" + id));

        doctor.setAge(doctorDetails.getAge());
        doctor.setName(doctorDetails.getName());
        doctor.setDegree(doctorDetails.getDegree());
        doctor.setExperiance(doctorDetails.getExperiance());
        doctor.setPrescription(doctorDetails.getPrescription());
        doctor.setId(doctorDetails.getId());

        doctor updatedPatient = doctorRepository.save(doctor);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteDoctor(@PathVariable Long id) throws AttributeNotFoundException{

        doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("ABCD" + id));

        doctorRepository.delete(doctor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}




