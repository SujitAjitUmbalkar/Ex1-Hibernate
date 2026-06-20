package com.codingshuttle.springboot0To100.hospitalManagementSystem.repository;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.IPatientInfo;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>
{
    @Query("select p.id as id , p.name as name , p.email as email from Patient p")
    List<IPatientInfo> getAllPatientsInfo();

}