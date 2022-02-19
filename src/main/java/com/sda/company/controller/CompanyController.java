package com.sda.company.controller;

import com.sda.company.dto.CompanyCreateDto;
import com.sda.company.dto.CompanyFullDto;
import com.sda.company.dto.CompanyResponseDto;
import com.sda.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @PostMapping("/create")
    public ResponseEntity<CompanyResponseDto> createCompany(@RequestBody CompanyCreateDto companyCreateDto) {
        CompanyResponseDto companyResponseDto = companyService.create(companyCreateDto);

        return ResponseEntity.ok(companyResponseDto);
    }

    @GetMapping("/findAll")
    public ResponseEntity findAll() {

        return null;
    }

    @GetMapping("/findByName")
    public ResponseEntity<CompanyFullDto> findByName(@RequestParam String companyName) {
        CompanyFullDto companyFullDto = companyService.findCompanyByName(companyName);
        return ResponseEntity.ok(companyFullDto);
    }

    @GetMapping("/findById")
    public ResponseEntity<CompanyFullDto> findById(@RequestParam Integer companyId) {
        CompanyFullDto companyFullDto = companyService.findCompanyById(companyId);
        return ResponseEntity.ok(companyFullDto);
    }

    @GetMapping("/findByNameAndRegistrationNumber")
    public ResponseEntity<CompanyFullDto> findByNameAndRegistrationNumber(@RequestParam String companyName, Long companyRegistrationNumber) {
        CompanyFullDto companyFullDto = companyService.findCompanyByNameAndRegistrationNumber(companyName, companyRegistrationNumber);
        return ResponseEntity.ok(companyFullDto);
    }
}