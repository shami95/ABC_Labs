package com.hms.hospital.repository;

import com.hms.hospital.model.doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<doctor, Long> {
    public void deleteById(Long id);
}




