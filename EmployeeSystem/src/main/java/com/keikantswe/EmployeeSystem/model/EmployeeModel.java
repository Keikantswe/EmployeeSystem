package com.keikantswe.EmployeeSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

    private Long id;

    private String firstName;
    private String lastName;
    private String emailId;
}
