package com.ltfullstack.employeeservice.query.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseModel {
    
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String Kin;
    private Boolean isDisciplined;
}
