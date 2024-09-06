package com.lab_java_add_and_update.controller;

import com.lab_java_add_and_update.DTO.EmployeeUpdateStatusDTO;
import com.lab_java_add_and_update.Enums.EmployeeDepartment;
import com.lab_java_add_and_update.Enums.EmployeeStatus;
import com.lab_java_add_and_update.model.Employee;
import com.lab_java_add_and_update.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee>getById(@PathVariable Integer id){
        Optional<Employee> employee=employeeService.getById(id);
        return employee.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/find/status")
    public ResponseEntity<List<Employee>> getByEmployeeStatus(@RequestParam EmployeeStatus status){
        List<Employee> employees = employeeService.getByStatus(status);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/find/statusOff")
    public ResponseEntity<List<Employee>> getByEmployeeStatusOff(){
        List<Employee> employees = employeeService.getByStatus(EmployeeStatus.OFF);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/find/department")
    public ResponseEntity<List<Employee>> getByDepartment(EmployeeDepartment department){
        List<Employee> employees =employeeService.getByDepartment(department);
        return  ResponseEntity.ok(employees);
    }

    @PostMapping()
    public Employee create(@RequestBody Employee employee){
       return employeeService.create(employee);
    }

    @PatchMapping("/update/status/{id}")
    public ResponseEntity<Employee> changeStatus(@PathVariable Integer id, EmployeeUpdateStatusDTO employeeUpdateStatusDTO){
        Optional<Employee> updateEmployee=employeeService.updateStatus(id,employeeUpdateStatusDTO);
        return updateEmployee.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/update/department/{id}")
    public ResponseEntity<Employee> updateDepartment(@PathVariable Integer id,@RequestBody Employee employee){
        Optional<Employee> updateEmployee=employeeService.updateDepartment(id,employee);
        return updateEmployee.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }



}
