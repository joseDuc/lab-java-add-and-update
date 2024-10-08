package com.lab_java_add_and_update.model;

import com.lab_java_add_and_update.Enums.EmployeeDepartment;
import com.lab_java_add_and_update.Enums.EmployeeStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Employee {
    @Id
    private Integer id;
    @Enumerated(EnumType.STRING)
    private EmployeeDepartment department;
    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

}
