package com.lab_java_add_and_update.controller;

import com.lab_java_add_and_update.Enums.EmployeeDepartment;
import com.lab_java_add_and_update.Enums.EmployeeStatus;
import com.lab_java_add_and_update.model.Patient;
import com.lab_java_add_and_update.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping
    public List<Patient> getAll(){
        return patientService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Long id){
        Optional<Patient> patient=patientService.getById(id);
        return patient.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/find/dateOfBirthBetween")
    public List<Patient> getByDateOfBirthBetween(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate){
            LocalDate star = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            return patientService.getByDateOfBirthBetween(star,end);
    }

    @GetMapping("/find/employeeDepartment")
    public List<Patient> getByEmployeeDepartment(EmployeeDepartment department){
        return patientService.getByEmployeeDepartment(department);
    }

    @GetMapping("/find/employeeStatus")
    public List<Patient> getByEmployeeStatus(EmployeeStatus status){
        return patientService.getByEmployeeStatus(status);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }
}
