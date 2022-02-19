package com.sda.company.mapper;

import com.sda.company.dto.CompanyCreateDto;
import com.sda.company.dto.CompanyFullDto;
import com.sda.company.dto.CompanyResponseDto;
import com.sda.company.model.Company;

public class CompanyMapper {

    public static Company companyToEntity(CompanyCreateDto companyCreateDto) {
        Company company = new Company();
        company.setName(companyCreateDto.getName());
        company.setAddress(companyCreateDto.getAddress());
        company.setPhoneNumber(companyCreateDto.getPhoneNumber());
        company.setEmail(companyCreateDto.getEmail());
        company.setRegistrationNumber(companyCreateDto.getRegistrationNumber());

        return company;
    }

    public static CompanyResponseDto companyToResponseDto(Company company) {
        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setId(company.getId());
        companyResponseDto.setName(company.getName());
        companyResponseDto.setRegistrationNumber(company.getRegistrationNumber());
        companyResponseDto.setPhoneNumber(company.getPhoneNumber());

        return companyResponseDto;
    }

    public static CompanyFullDto companyToFullDto(Company company) {
        CompanyFullDto companyFullDto = new CompanyFullDto();
        companyFullDto.setId(company.getId());
        companyFullDto.setName(company.getName());
        companyFullDto.setRegistrationNumber(company.getRegistrationNumber());
        companyFullDto.setPhoneNumber(company.getPhoneNumber());
        companyFullDto.setAddress(company.getAddress());
        companyFullDto.setEmail(company.getEmail());

        return companyFullDto;

    }
}
