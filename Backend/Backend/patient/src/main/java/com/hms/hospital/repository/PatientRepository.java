package com.hms.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.hospital.model.patient;

@Repository
public interface PatientRepository extends JpaRepository<patient, Long> {

	public void deleteById(Long id);



	}


