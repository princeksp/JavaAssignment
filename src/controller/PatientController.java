package com.example.demo.controller;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

  @Autowired
  private PatientRepository patientRepository;

  @PostMapping("/add")
  public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) {
    return ResponseEntity.ok(patientRepository.save(patient));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deletePatient(@PathVariable Long id) {
    patientRepository.deleteById(id);
    return ResponseEntity.ok("Patient deleted successfully");
  }

  @GetMapping("/all")
  public ResponseEntity<List<Patient>> getAllPatients() {
    return ResponseEntity.ok(patientRepository.findAll());
  }
}