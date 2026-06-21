package com.codingshuttle.springboot0To100.hospitalManagementSystem;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.repository.PatientRepository;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalManagementSystemApplication
{
    private final PatientService patientService;

    public HospitalManagementSystemApplication(PatientService patientService) {
        this.patientService = patientService;
    }

    public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}

//    @Override
//    public void run(String... args) throws Exception
//    {
//           patientService.testPatientTransaction();
//    }
}
