package com.keikantswe.EmployeeSystem.controller;


import com.keikantswe.EmployeeSystem.model.EmployeeModel;
import com.keikantswe.EmployeeSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee( @PathVariable Long id){
        boolean deleted = false;

        deleted = employeeService.deleteEmployee(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted" , deleted);
        return ResponseEntity.ok(response);
    }
}
