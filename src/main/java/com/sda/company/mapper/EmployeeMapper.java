package com.sda.company.mapper;

import com.sda.company.dto.EmployeeCreateDto;
import com.sda.company.dto.EmployeeFullDto;
import com.sda.company.dto.EmployeeResponseDto;
import com.sda.company.model.Employee;

public class EmployeeMapper {
    public static Employee employeeToEntity(EmployeeCreateDto employeeCreateDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeCreateDto.getFirstName());
        employee.setLastName(employeeCreateDto.getLastName());
        employee.setEmail(employeeCreateDto.getEmail());
        employee.setAddress(employeeCreateDto.getAddress());
        employee.setPhone(employeeCreateDto.getPhone());
        employee.setPersonalNumericCode(employeeCreateDto.getPersonalNumericCode());
        employee.setHired(employeeCreateDto.isHired());

        return employee;
    }

    public static EmployeeResponseDto employeeToResponseDto(Employee employee) {
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setFirstName(employee.getFirstName());
        employeeResponseDto.setLastName(employee.getLastName());
        employeeResponseDto.setPersonalNumericCode(employee.getPersonalNumericCode());

        return employeeResponseDto;
    }

    public static EmployeeFullDto employeeToFullDto(Employee employee) {
        EmployeeFullDto employeeFullDto = new EmployeeFullDto();
        employeeFullDto.setId(employee.getId());
        employeeFullDto.setFirstName(employee.getFirstName());
        employeeFullDto.setLastName(employee.getLastName());
        employeeFullDto.setEmail(employee.getEmail());
        employeeFullDto.setAddress(employee.getAddress());
        employeeFullDto.setPhone(employee.getPhone());
        employeeFullDto.setPersonalNumericCode(employee.getPersonalNumericCode());
        employeeFullDto.setHired(employee.isHired());

        return employeeFullDto;
    }
}
