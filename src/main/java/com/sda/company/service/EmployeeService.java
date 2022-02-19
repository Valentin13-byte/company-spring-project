package com.sda.company.service;

import com.sda.company.dto.EmployeeCreateDto;
import com.sda.company.dto.EmployeeFullDto;
import com.sda.company.dto.EmployeeResponseDto;

public interface EmployeeService {

EmployeeResponseDto create (EmployeeCreateDto employeeCreateDto);

EmployeeFullDto findEmployeeByFirstNameAndLastName(String firstName, String lastName);
}
