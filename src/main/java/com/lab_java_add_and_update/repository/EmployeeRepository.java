package com.lab_java_add_and_update.repository;

import com.lab_java_add_and_update.Enums.EmployeeDepartment;
import com.lab_java_add_and_update.Enums.EmployeeStatus;
import com.lab_java_add_and_update.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByStatus(EmployeeStatus status);
    List<Employee> findByDepartment(EmployeeDepartment department);

}
