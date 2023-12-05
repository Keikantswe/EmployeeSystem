package com.keikantswe.EmployeeSystem.service;

import com.keikantswe.EmployeeSystem.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    EmployeeModel saveEmployee(EmployeeModel employeeModel);


    List<EmployeeModel> fetchAllEmployees();
}
