package com.codingshuttle.springboot0To100.hospitalManagementSystem.service;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.Insurance;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.repository.InsuranceRepository;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService
{
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    public Insurance assignInsuranceToPatient(Insurance insurance , Long patientId)
    {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);
        patientRepository.save(patient);        // save manually , if @Transactional is missing

        return  insurance;
    }
}

/*

When an entity references another new (unsaved) entity,
Hibernate cannot automatically persist the referenced entity unless Cascade is configured.

Example:
Patient -> Insurance

patient.setInsurance(insurance);
patientRepository.save(patient);

If 'insurance' is a new object and no CascadeType.PERSIST or CascadeType.ALL is configured,
 Hibernate may throw a TransientObjectException because Patient references an Insurance entity that does not yet exist in the database.

Solutions:
1. Save the referenced entity first:
   insuranceRepository.save(insurance);
   patientRepository.save(patient);

2. Enable cascading:
   @OneToOne(cascade = CascadeType.ALL)

With cascade enabled, saving the parent entity automatically saves the related child entity as well.

Key Rule:
Without Cascade, save related entities manually.
With Cascade, Hibernate saves them automatically.

 */