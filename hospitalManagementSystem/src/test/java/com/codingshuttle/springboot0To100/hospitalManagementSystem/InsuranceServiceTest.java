package com.codingshuttle.springboot0To100.hospitalManagementSystem;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.Insurance;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.repository.PatientRepository;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.service.InsuranceService;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles("test")
public class InsuranceServiceTest
{
    @Autowired
     InsuranceService insuranceService;

    @Autowired
     PatientService patientService;

    @Autowired
     PatientRepository patientRepository;

    @Test
    public void testInsuranceService()
    {
        Insurance insurance = Insurance.builder()
                .policyNumber("123456")
//                .id(1L)
                .provider("HDFC")
                .validUntil(LocalDate.of(2020, 1, 1))
                .build();

        Insurance savedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);

        System.out.println(savedInsurance);
    }

}
