package com.sda.company.controller;

import com.github.javafaker.Faker;
import com.sda.company.components.CustomFakerCompany;
import com.sda.company.config.AppConfig;
import com.sda.company.dto.CompanyCreateDto;
import com.sda.company.dto.CompanyFullDto;
import com.sda.company.dto.CompanyResponseDto;
import com.sda.company.model.Company;
import com.sda.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CustomFakerCompany customFakerCompany;

    @GetMapping("/generateCompanies")
    public void generateCompanies() {
        List<Company> listOfCompanies = customFakerCompany.createDummyCompanyList();
        companyService.saveAllCompanies(listOfCompanies);
    }

    @PostMapping("/create")
    public ResponseEntity<CompanyResponseDto> createCompany(@RequestBody CompanyCreateDto companyCreateDto) {
        CompanyResponseDto companyResponseDto = companyService.create(companyCreateDto);

        return ResponseEntity.ok(companyResponseDto);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CompanyFullDto>> findAll(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                        @RequestParam(defaultValue = "5") Integer pageSize,
                                                        @RequestParam(defaultValue = "id") String sortBy) {

        List<CompanyFullDto> listOfCompany = companyService.findAll(pageNumber,pageSize,sortBy);

        return ResponseEntity.ok(listOfCompany);
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
    public ResponseEntity<CompanyFullDto> findByNameAndRegistrationNumber(@RequestParam String companyName,
                                                                          @RequestParam Long companyRegistrationNumber) {
        CompanyFullDto companyFullDto = companyService.findCompanyByNameAndRegistrationNumber(companyName, companyRegistrationNumber);
        return ResponseEntity.ok(companyFullDto);
    }


}