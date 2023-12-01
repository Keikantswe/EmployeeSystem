package com.keikantswe.EmployeeSystem.service;

import com.keikantswe.EmployeeSystem.entity.EmployeeEntity;
import com.keikantswe.EmployeeSystem.model.EmployeeModel;
import com.keikantswe.EmployeeSystem.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
