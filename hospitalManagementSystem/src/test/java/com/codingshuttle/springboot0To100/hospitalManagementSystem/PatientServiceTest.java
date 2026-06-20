package com.codingshuttle.springboot0To100.hospitalManagementSystem;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.IPatientInfo;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class PatientServiceTest
{
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient()
    {
        System.out.println("Printing All Data from Entity");

        List<Patient> patients = patientRepository.findAll();
        for(Patient patient : patients)
        {
            System.out.println(patient);
        }

        // / /////////////////////////////////////////
        System.out.println("Printing Required Data using Projection Interface ");

        List<IPatientInfo> patients1 = patientRepository.getAllPatientsInfo();

    //        for(IPatientInfo patientInfo : patients1) {System.out.println(patientInfo);}
    // Directly printing may show a proxy object instead of meaningful data,
    // so we access values through getter methods.

        for(IPatientInfo p : patients1)
        {
            System.out.printf("%d %s %s%n",
                    p.getId(),
                    p.getName(),
                    p.getEmail());
        }
    }

}
