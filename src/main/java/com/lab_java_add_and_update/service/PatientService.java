package com.lab_java_add_and_update.service;

import com.lab_java_add_and_update.Enums.EmployeeDepartment;
import com.lab_java_add_and_update.Enums.EmployeeStatus;
import com.lab_java_add_and_update.model.Patient;
import com.lab_java_add_and_update.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAll(){
        return patientRepository.findAll();
    }

    public Optional<Patient> getById(Long id){
        return patientRepository.findById(id);
    }

    public List<Patient> getByDateOfBirthBetween(LocalDate startDate, LocalDate endDate ){
        return patientRepository.findByDateOfBirthBetween(startDate,endDate);
    }

    public List<Patient> getByEmployeeDepartment(EmployeeDepartment department){
        return patientRepository.findByEmployeeDepartment(department);
    }

    public List<Patient> getByEmployeeStatus(EmployeeStatus status){
        return patientRepository.findByEmployeeStatus(status);
    }

    public Patient create(Patient patient){
        return patientRepository.save(patient);
    }

    public Optional<Patient> update(Long id , Patient patient){
        if (patientRepository.existsById(id)){
            patient.setId(id);
            return Optional.of( patientRepository.save(patient));
        }
        return Optional.empty();
    }
}
