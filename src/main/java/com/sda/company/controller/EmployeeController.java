package com.sda.company.controller;

import com.sda.company.dto.EmployeeCreateDto;
import com.sda.company.dto.EmployeeFullDto;
import com.sda.company.dto.EmployeeResponseDto;
import com.sda.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeCreateDto employeeCreateDto) {
        EmployeeResponseDto employeeResponseDto = employeeService.create(employeeCreateDto);

        return ResponseEntity.ok(employeeResponseDto);
    }

    @GetMapping("/findByFirstNameAndLastName")
<<<<<<< HEAD
    public ResponseEntity<EmployeeFullDto> findByFirstNameAndLastName(@RequestParam String firstName,
                                                                      @RequestParam String lastName) {
=======
    public ResponseEntity<EmployeeFullDto> findByFirstNameAndLastName(@RequestParam String firstName,@RequestParam String lastName) {
>>>>>>> origin/main
        EmployeeFullDto employeeFullDto = employeeService.findEmployeeByFirstNameAndLastName(firstName, lastName);
        return ResponseEntity.ok(employeeFullDto);
    }
}
