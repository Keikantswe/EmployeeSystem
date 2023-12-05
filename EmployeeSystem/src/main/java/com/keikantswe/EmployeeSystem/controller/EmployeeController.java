package com.keikantswe.EmployeeSystem.controller;


import com.keikantswe.EmployeeSystem.model.EmployeeModel;
import com.keikantswe.EmployeeSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public EmployeeModel saveEmployee(@RequestBody EmployeeModel employeeModel){
       return employeeService.saveEmployee(employeeModel);
    }

    @GetMapping("/employees")
    public List<EmployeeModel> fetchAllEmployees(){
        return  employeeService.fetchAllEmployees();
    }
}
