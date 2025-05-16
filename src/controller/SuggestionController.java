package com.example.demo.controller;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.util.SymptomSpecialityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/suggest")
public class SuggestionController {

  @Autowired
  private PatientRepository patientRepository;

  @Autowired
  private DoctorRepository doctorRepository;

  @GetMapping("/doctor/{patientId}")
  public ResponseEntity<?> suggestDoctor(@PathVariable Long patientId) {
    Optional<Patient> patientOpt = patientRepository.findById(patientId);
    if (patientOpt.isEmpty()) {
      return ResponseEntity.status(404).body("Patient not found");
    }

    Patient patient = patientOpt.get();
    String speciality = SymptomSpecialityMapper.symptomToSpeciality.get(patient.getSymptom());

    if (speciality == null) {
      return ResponseEntity.status(400).body("Symptom not recognized");
    }

    if (!List.of("Delhi", "Noida", "Faridabad").contains(patient.getCity())) {
      return ResponseEntity.ok("We are still waiting to expand to your location");
    }

    List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(patient.getCity(), speciality);

    if (doctors.isEmpty()) {
      return ResponseEntity.ok("There isn’t any doctor present at your location for your symptom");
    }

    return ResponseEntity.ok(doctors);
  }
}
