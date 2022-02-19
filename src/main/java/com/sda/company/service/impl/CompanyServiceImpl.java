package com.sda.company.service.impl;

import com.sda.company.dto.CompanyCreateDto;
import com.sda.company.dto.CompanyFullDto;
import com.sda.company.dto.CompanyResponseDto;
import com.sda.company.mapper.CompanyMapper;
import com.sda.company.model.Company;
import com.sda.company.repository.CompanyRepository;
import com.sda.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyResponseDto create(CompanyCreateDto companyCreateDto) {
        Company company = CompanyMapper.companyToEntity(companyCreateDto);
        Company savedCompany = companyRepository.save(company);

        return CompanyMapper.companyToResponseDto(savedCompany);
    }

    @Override
    public CompanyFullDto findCompanyByName(String name) {
        Company company = companyRepository.findByName(name).orElseThrow(() -> new RuntimeException("Company not found"));

        return CompanyMapper.companyToFullDto(company);
    }

    @Override
    public CompanyFullDto findCompanyById(Integer id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));

        return CompanyMapper.companyToFullDto(company);
    }

    @Override
    public CompanyFullDto findCompanyByNameAndRegistrationNumber(String name, Long registrationNumber) {
        Company company = companyRepository.findByNameAndRegistrationNumber(name, registrationNumber)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        return CompanyMapper.companyToFullDto(company);
    }
}
