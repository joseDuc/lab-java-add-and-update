package com.lab_java_add_and_update.repository;

import com.lab_java_add_and_update.Enums.EmployeeDepartment;
import com.lab_java_add_and_update.Enums.EmployeeStatus;
import com.lab_java_add_and_update.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.dateOfBirth BETWEEN :startDate AND :endDate")
    List<Patient> findByDateOfBirthBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT p FROM Patient p WHERE p.admittedBy.department = :department")
    List<Patient> findByEmployeeDepartment(@Param("department") EmployeeDepartment department);

    @Query("SELECT p FROM Patient p WHERE p.admittedBy.status = :status")
    List<Patient> findByEmployeeStatus(@Param("status") EmployeeStatus status);

}
