package com.sda.company.service.impl;

import com.sda.company.dto.EmployeeCreateDto;
import com.sda.company.dto.EmployeeFullDto;
import com.sda.company.dto.EmployeeResponseDto;
import com.sda.company.mapper.CompanyMapper;
import com.sda.company.mapper.EmployeeMapper;
import com.sda.company.model.Employee;
import com.sda.company.repository.EmployeeRepository;
import com.sda.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponseDto create(EmployeeCreateDto employeeCreateDto) {
        Employee employee = EmployeeMapper.employeeToEntity(employeeCreateDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.employeeToResponseDto(savedEmployee);
    }

    @Override
    public EmployeeFullDto findEmployeeByFirstNameAndLastName(String firstName, String lastName) {
        Employee employee = employeeRepository.findByFirstNameAndLastName(firstName, lastName).orElseThrow(() -> new RuntimeException("Employee not found"));

        return EmployeeMapper.employeeToFullDto(employee);
    }
}
