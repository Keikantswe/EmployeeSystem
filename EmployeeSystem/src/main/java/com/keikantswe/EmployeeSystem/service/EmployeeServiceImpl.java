package com.keikantswe.EmployeeSystem.service;

import com.keikantswe.EmployeeSystem.entity.EmployeeEntity;
import com.keikantswe.EmployeeSystem.model.EmployeeModel;
import com.keikantswe.EmployeeSystem.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeModel saveEmployee(EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employeeModel , employeeEntity);

        employeeRepository.save(employeeEntity);

        return employeeModel;
    }

    @Override
    public List<EmployeeModel> fetchAllEmployees() {

        List<EmployeeEntity> employeeEntities =  employeeRepository.findAll();

        List<EmployeeModel> employeeModel = employeeEntities
                .stream()
                .map( employee -> new EmployeeModel(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmailId()))
                .collect(Collectors.toList());

        return employeeModel;
    }


}
