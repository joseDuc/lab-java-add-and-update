package com.lab_java_add_and_update.DTO;

import com.lab_java_add_and_update.Enums.EmployeeStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeUpdateStatusDTO {
    @NotBlank
    @Enumerated
    EmployeeStatus status;
}
