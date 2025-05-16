package com.example.demo.controller;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

  @Autowired
  private DoctorRepository doctorRepository;

  @PostMapping("/add")
  public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor) {
    return ResponseEntity.ok(doctorRepository.save(doctor));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
    doctorRepository.deleteById(id);
    return ResponseEntity.ok("Doctor deleted successfully");
  }

  @GetMapping("/all")
  public ResponseEntity<List<Doctor>> getAllDoctors() {
    return ResponseEntity.ok(doctorRepository.findAll());
  }
}