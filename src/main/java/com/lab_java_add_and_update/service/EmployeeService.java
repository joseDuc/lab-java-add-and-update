package com.lab_java_add_and_update.service;

import com.lab_java_add_and_update.Enums.EmployeeDepartment;
import com.lab_java_add_and_update.Enums.EmployeeStatus;
import com.lab_java_add_and_update.model.Employee;
import com.lab_java_add_and_update.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll(){return employeeRepository.findAll();}

    public Optional<Employee> getById(Integer id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getByStatus(EmployeeStatus status){
        return employeeRepository.findByStatus(status);
    }


    public List<Employee> getByDepartment(EmployeeDepartment department){
        return employeeRepository.findByDepartment(department);
    }

}
